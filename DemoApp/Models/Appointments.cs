using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace DemoApp.Models
{
    public class Appointments
    {
        public int Id { get; set; }

        [Required]
        [StringLength(255)]
        public string Name { get; set; }
        
        [Required]
        [Display(Name = "Gender")]
        public Gender CustomerGender { get; set; }

        [Required]
        [EmailAddress]
        public string Email { get; set; }

        //[Required]
        //[Phone]
        public long Phone { get; set; }


        [Required]
        [Display(Name = "Appointment Date")]
        public DateTime ApptDate { get; set; }


        [Required]
        [Display(Name = "Appointment From")]

        public string selTimeF { get; set; }

        [Required]
        [Display(Name = "Appointment To")]
        public string selTimeT { get; set; }
    }

    public enum Gender
    {
        Male, Female, Other
       
    }
}


