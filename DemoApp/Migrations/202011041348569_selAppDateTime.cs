namespace DemoApp.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class selAppDateTime : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Appointments", "selTimeF", c => c.Double(nullable: false));
            AddColumn("dbo.Appointments", "selTimeT", c => c.Double(nullable: false));
        }
        
        public override void Down()
        {
            DropColumn("dbo.Appointments", "selTimeT");
            DropColumn("dbo.Appointments", "selTimeF");
        }
    }
}
