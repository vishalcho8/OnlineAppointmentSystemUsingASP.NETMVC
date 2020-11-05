using System.Web;
using System.Web.Optimization;

namespace DemoApp
{
    public class BundleConfig
    {
        // For more information on bundling, visit https://go.microsoft.com/fwlink/?LinkId=301862
        public static void RegisterBundles(BundleCollection bundles)
        {
            //we are consolidating this bundle together to get rid of bootstrap bundle which commented now. added reference of this in _layout.cshtml page.
            bundles.Add(new ScriptBundle("~/bundles/lib").Include(
                        "~/Scripts/jquery-{version}.js",
                        "~/Scripts/bootstrap.js",
                        "~/scripts/bootbox.js", //For bootbox message box/confirmation pop up appearing while deleting record.
                        "~/Scripts/respond.js",
                        "~/scripts/datatables/jquery.datatables.js", //for pagination and sorting
                        "~/scripts/datatables/datatables.bootstrap.js")); //for pagination and sorting

            bundles.Add(new ScriptBundle("~/bundles/jqueryval").Include(
                        "~/Scripts/jquery.validate*"));

            // Use the development version of Modernizr to develop with and learn from. Then, when you're
            // ready for production, use the build tool at https://modernizr.com to pick only the tests you need.
            bundles.Add(new ScriptBundle("~/bundles/modernizr").Include(
                        "~/Scripts/modernizr-*"));

           /* bundles.Add(new ScriptBundle("~/bundles/bootstrap").Include(
                      "~/Scripts/bootstrap.js",
                      "~/scripts/bootbox.js")); */ //added this bundels in lib. 

            bundles.Add(new StyleBundle("~/Content/css").Include(
                      "~/Content/bootstrap.css",
                      "~/content/datatables/css/datatables.bootstrap.css", //For pagination and sorting
                      "~/Content/site.css"));
        }
    }
}
