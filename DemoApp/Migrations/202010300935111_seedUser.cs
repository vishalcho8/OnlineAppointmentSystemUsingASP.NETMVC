namespace DemoApp.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class seedUser : DbMigration
    {
        public override void Up()
        {
            Sql(@"
            INSERT INTO[dbo].[AspNetUsers] ([Id], [Email], [EmailConfirmed], [PasswordHash], [SecurityStamp], [PhoneNumber], [PhoneNumberConfirmed], [TwoFactorEnabled], [LockoutEndDateUtc], [LockoutEnabled], [AccessFailedCount], [UserName]) VALUES(N'05fab84e-961f-4677-8b3f-41f4a92990e2', N'admin@ok.com', 0, N'AAuhWdqg8PIbFNauOoCLUcIbOYTFOw77uzjgoNtFeRo0VQu94dFzHeXQjlqwG4UCGA==', N'1ec11800-2509-44d9-b59e-7922a44a29e1', NULL, 0, 0, NULL, 1, 0, N'admin@ok.com')
            INSERT INTO[dbo].[AspNetUsers] ([Id], [Email], [EmailConfirmed], [PasswordHash], [SecurityStamp], [PhoneNumber], [PhoneNumberConfirmed], [TwoFactorEnabled], [LockoutEndDateUtc], [LockoutEnabled], [AccessFailedCount], [UserName]) VALUES(N'19cf38bf-dcc8-4b88-abbc-368029d8db6b', N'Staff@ok.com', 0, N'AGA/R71+A2yYS97dIxp/hhlyaDivfkrNiKiQ9rpNd9OfQ2PsZFwGnKL4RI5Mg/JRPg==', N'4b56e9f7-4d37-46b1-b6a1-055d063e460b', NULL, 0, 0, NULL, 1, 0, N'Staff@ok.com')
            INSERT INTO [dbo].[AspNetRoles] ([Id], [Name]) VALUES (N'8ad307a2-6607-4a96-bf34-295242eb5697', N'CanDeleteAppointment')
            INSERT INTO [dbo].[AspNetUserRoles] ([UserId], [RoleId]) VALUES (N'05fab84e-961f-4677-8b3f-41f4a92990e2', N'8ad307a2-6607-4a96-bf34-295242eb5697')
            INSERT INTO [dbo].[AspNetUserRoles] ([UserId], [RoleId]) VALUES (N'19cf38bf-dcc8-4b88-abbc-368029d8db6b', N'8ad307a2-6607-4a96-bf34-295242eb5697')

            ");

        }

        public override void Down()
        {
        }
    }
}
