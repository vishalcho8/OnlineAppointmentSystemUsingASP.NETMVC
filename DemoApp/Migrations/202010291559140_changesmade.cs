namespace DemoApp.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class changesmade : DbMigration
    {
        public override void Up()
        {
            RenameTable(name: "dbo.AppointmentModels", newName: "Appointments");
            AlterColumn("dbo.Appointments", "Phone", c => c.Long(nullable: false));
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Appointments", "Phone", c => c.Int(nullable: false));
            RenameTable(name: "dbo.Appointments", newName: "AppointmentModels");
        }
    }
}
