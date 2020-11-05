using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices;
using System.Web;
using System.Web.Mvc;
using DemoApp.Models;
using System.Linq.Expressions;

namespace DemoApp.Controllers
{
    public class AppointmentController : Controller
    {
        private ApplicationDbContext _appDBContextInst;

        public AppointmentController()
        {
            _appDBContextInst = new ApplicationDbContext();
        }

        protected override void Dispose(bool disposing)
        {
            _appDBContextInst.Dispose();
        }
        // GET: Appointment
        public ActionResult Index()
        {
            var appointments = _appDBContextInst.Appointment.ToList();
            //return View(appointments);

            if (User.IsInRole(RoleName.CanDeleteAppointment))
                return View("Index", appointments);

            return View("ReadOnlyView", appointments);
        }

        public ActionResult New(Appointments appointment)
        {
            ViewBag.TimeFrom = GetTimeF(); 
            ViewBag.TimeTo = GetTimeT();
            return View("AppointmentForm", appointment);
        }

        public ActionResult Edit(int id)
        {
            ViewBag.TimeFrom = GetTimeF();
            ViewBag.TimeTo = GetTimeT();

            var existingAppointmentDetails = _appDBContextInst.Appointment.SingleOrDefault(m => m.Id == id);

            if (existingAppointmentDetails == null)
                return HttpNotFound();
   
            return View("AppointmentForm", existingAppointmentDetails);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Save(Appointments appointment)
        {
            ViewBag.TimeFrom = GetTimeF();
            ViewBag.TimeTo = GetTimeT();

            /*if (_appDBContextInst.Appointment.Any(m => m.ApptDate == appointment.ApptDate
                 && x < float.Parse(m.selTimeT) 
                 && y > float.Parse(m.selTimeF) ))
           {

               return View("AppointmentForm", appointment);
           } */

            float FselTimeF = float.Parse(appointment.selTimeF);
            float FselTimeT = float.Parse(appointment.selTimeT);

            var allapp = _appDBContextInst.Appointment.ToList();

            foreach(var AllApp in allapp) {
                if (AllApp.ApptDate == appointment.ApptDate &&
                 FselTimeF < float.Parse(AllApp.selTimeT) &&
                 FselTimeT > float.Parse(AllApp.selTimeF))
                {
                    ModelState.AddModelError("Error", "Appointment is already scheduled for this date and time.");
                    return View("AppointmentForm", appointment);
                }
            };


            if (appointment.ApptDate < DateTime.Now.Date)
            {
                ModelState.AddModelError("Error", "Appointment date cannot be less than Today.");
                return View("AppointmentForm", appointment);
            }
            else if (FselTimeF == FselTimeT)
            {
                ModelState.AddModelError("Error", "Appointment from and Appointment to cannot be same.");
                return View("AppointmentForm", appointment);
            }
            else if (FselTimeF > FselTimeT)
            {
                ModelState.AddModelError("Error", "Appointment from must be less than Appointment to.");
                return View("AppointmentForm", appointment);
            }
            /* if (!ModelState.IsValid)
            {              

                return View("AppointmentForm", AppModel);
            } */

            if (appointment.Id == 0)
                _appDBContextInst.Appointment.Add(appointment);
            else
            {
                var appInDb = _appDBContextInst.Appointment.Single(m => m.Id == appointment.Id);
                appInDb.Name = appointment.Name;
                appInDb.CustomerGender = appointment.CustomerGender;
                appInDb.Email = appointment.Email;
                appInDb.Phone = appointment.Phone;
                appInDb.ApptDate = appointment.ApptDate;
                appInDb.selTimeF = appointment.selTimeF;
                appInDb.selTimeT = appointment.selTimeT;
            }

            _appDBContextInst.SaveChanges();
            return RedirectToAction("Index", "Appointment");
        }

        //[HttpDelete]
        public ActionResult Delete(int id)
        {
            var delAppointment = _appDBContextInst.Appointment.SingleOrDefault(m => m.Id == id);

            if (delAppointment == null)
                return HttpNotFound();

            _appDBContextInst.Appointment.Remove(delAppointment);
            _appDBContextInst.SaveChanges();

            return RedirectToAction("Index", "Appointment");

                        
        }

        private List<SelectListItem> GetTimeF()
        {

            List<SelectListItem> TimeFrom = new List<SelectListItem>();
            TimeFrom.Add(new SelectListItem { Value = "09.00", Text = "09:00" });
            TimeFrom.Add(new SelectListItem { Value = "09.30", Text = "09:30" });
            TimeFrom.Add(new SelectListItem { Value = "10.00", Text = "10:00" });
            TimeFrom.Add(new SelectListItem { Value = "10.30", Text = "10:30" });
            TimeFrom.Add(new SelectListItem { Value = "11.00", Text = "11:00" });
            TimeFrom.Add(new SelectListItem { Value = "11.30", Text = "11:30" });
            TimeFrom.Add(new SelectListItem { Value = "12.00", Text = "12:00" });
            TimeFrom.Add(new SelectListItem { Value = "12.30", Text = "12:30" });
            TimeFrom.Add(new SelectListItem { Value = "13.00", Text = "13:00" });
            TimeFrom.Add(new SelectListItem { Value = "13.30", Text = "13:30" });
            TimeFrom.Add(new SelectListItem { Value = "14.00", Text = "14:00" });
            TimeFrom.Add(new SelectListItem { Value = "14.30", Text = "14:30" });
            TimeFrom.Add(new SelectListItem { Value = "15.00", Text = "15:00" });
            TimeFrom.Add(new SelectListItem { Value = "15.30", Text = "15:30" });
            TimeFrom.Add(new SelectListItem { Value = "16.00", Text = "16:00" });
            TimeFrom.Add(new SelectListItem { Value = "16.30", Text = "16:30" });
            TimeFrom.Add(new SelectListItem { Value = "17.00", Text = "17:00" });
            TimeFrom.Add(new SelectListItem { Value = "17.30", Text = "17:30" });
            return TimeFrom;
            /*DateTime AppFromstart = DateTime.ParseExact("09:00", "HH:mm", null);
            DateTime AppFromend = DateTime.ParseExact("17:30", "HH:mm", null);

            List<SelectListItem> TimeFrom = new List<SelectListItem>();
            TimeFrom.Add(new SelectListItem() { Text = AppFromstart.ToString("t"), Value = AppFromstart.ToString("t") });
            int i = 0;
            while (AppFromstart < AppFromend)
            {
                TimeFrom.Add(new SelectListItem() { Text = AppFromstart.AddMinutes(30).ToString("t"), Value = AppFromstart.AddMinutes(30).ToString("t") });
                AppFromstart = AppFromstart.AddMinutes(30);
                i += 1;
                
            }

            return TimeFrom; */

        }

        private List<SelectListItem> GetTimeT()
        {
            List<SelectListItem> TimeTo = new List<SelectListItem>();
            TimeTo.Add(new SelectListItem { Value = "09.30", Text = "09:30" });
            TimeTo.Add(new SelectListItem { Value = "10.00", Text = "10:00" });
            TimeTo.Add(new SelectListItem { Value = "10.30", Text = "10:30" });
            TimeTo.Add(new SelectListItem { Value = "11.00", Text = "11:00" });
            TimeTo.Add(new SelectListItem { Value = "11.30", Text = "11:30" });
            TimeTo.Add(new SelectListItem { Value = "12.00", Text = "12:00" });
            TimeTo.Add(new SelectListItem { Value = "12.30", Text = "12:30" });
            TimeTo.Add(new SelectListItem { Value = "13.00", Text = "13:00" });
            TimeTo.Add(new SelectListItem { Value = "13.30", Text = "13:30" });
            TimeTo.Add(new SelectListItem { Value = "14.00", Text = "14:00" });
            TimeTo.Add(new SelectListItem { Value = "14.30", Text = "14:30" });
            TimeTo.Add(new SelectListItem { Value = "15.00", Text = "15:00" });
            TimeTo.Add(new SelectListItem { Value = "15.30", Text = "15:30" });
            TimeTo.Add(new SelectListItem { Value = "16.00", Text = "16:00" });
            TimeTo.Add(new SelectListItem { Value = "16.30", Text = "16:30" });
            TimeTo.Add(new SelectListItem { Value = "17.00", Text = "17:00" });
            TimeTo.Add(new SelectListItem { Value = "17.30", Text = "17:30" });
            TimeTo.Add(new SelectListItem { Value = "18.00", Text = "18:00" });
            return TimeTo;
            /*DateTime Apptostart = DateTime.ParseExact("09:30", "HH:mm", null);
            DateTime AppToend = DateTime.ParseExact("18:00", "HH:mm", null);

            List<SelectListItem> TimeTo = new List<SelectListItem>();
            TimeTo.Add(new SelectListItem() { Text = Apptostart.ToString("t"), Value = Apptostart.ToString("t") });
            int j = 0;
            while (Apptostart < AppToend)
            {
                TimeTo.Add(new SelectListItem() { Text = Apptostart.AddMinutes(30).ToString("t"), Value = Apptostart.AddMinutes(30).ToString("t") });
                Apptostart = Apptostart.AddMinutes(30);
                j += 1;
            }

            return TimeTo; */

        }
    }

}