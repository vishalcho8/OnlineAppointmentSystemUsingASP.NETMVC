namespace Vidly.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class SeedUsers : DbMigration
    {
        public override void Up()
        {
            Sql(@"
            INSERT INTO [dbo].[AspNetUsers] ([Id], [Email], [EmailConfirmed], [PasswordHash], [SecurityStamp], [PhoneNumber], [PhoneNumberConfirmed], [TwoFactorEnabled], [LockoutEndDateUtc], [LockoutEnabled], [AccessFailedCount], [UserName]) VALUES (N'4771d50d-219d-40d1-8150-0ed5df74b865', N'guest@vidly.com', 0, N'AHqHmPX8YpwwOfgXMdRKVwRm0Oi4hfNjfVpknJKdqu4BfecNpNdSi81rwpg6ch9+yg==', N'5bf1ad49-68e0-4801-8e0a-fad3b22062b4', NULL, 0, 0, NULL, 1, 0, N'guest@vidly.com')
            INSERT INTO [dbo].[AspNetUsers] ([Id], [Email], [EmailConfirmed], [PasswordHash], [SecurityStamp], [PhoneNumber], [PhoneNumberConfirmed], [TwoFactorEnabled], [LockoutEndDateUtc], [LockoutEnabled], [AccessFailedCount], [UserName]) VALUES (N'f30a6a0d-bbd6-4e09-b8dc-440cbd9cb906', N'admin@vidly.com', 0, N'AMphBFy1T/vNlX7nm6htu9ne1FS3I3oceayL2B2p2KhxpxZgSvObGmF56HTdxenv1Q==', N'90123b0d-aded-4585-9058-8728d93f741f', NULL, 0, 0, NULL, 1, 0, N'admin@vidly.com')
            INSERT INTO [dbo].[AspNetRoles] ([Id], [Name]) VALUES (N'453221c2-3791-4f0a-937e-38c2d73e694c', N'CanManageMovies')
            INSERT INTO [dbo].[AspNetUserRoles] ([UserId], [RoleId]) VALUES (N'f30a6a0d-bbd6-4e09-b8dc-440cbd9cb906', N'453221c2-3791-4f0a-937e-38c2d73e694c')

            ");
        }
        
        public override void Down()
        {
        }
    }
}
