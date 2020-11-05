namespace DemoApp.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class InitialMigration1 : DbMigration
    {
        public override void Up()
        {
            DropColumn("dbo.AppointmentModels", "ApptFrom");
            DropColumn("dbo.AppointmentModels", "ApptTo");
        }
        
        public override void Down()
        {
            AddColumn("dbo.AppointmentModels", "ApptTo", c => c.String());
            AddColumn("dbo.AppointmentModels", "ApptFrom", c => c.String());
        }
    }
}
