namespace DemoApp.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class selAppDateTime1 : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Appointments", "selTimeF", c => c.String(nullable: false));
            AlterColumn("dbo.Appointments", "selTimeT", c => c.String(nullable: false));
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Appointments", "selTimeT", c => c.Double(nullable: false));
            AlterColumn("dbo.Appointments", "selTimeF", c => c.Double(nullable: false));
        }
    }
}
