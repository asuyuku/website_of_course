/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : SQL Server
 Source Server Version : 11002100
 Source Host           : localhost:1433
 Source Catalog        : one
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 11002100
 File Encoding         : 65001

 Date: 31/12/2019 15:38:54
*/


-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[admin_user]') AND type IN ('U'))
	DROP TABLE [dbo].[admin_user]
GO

CREATE TABLE [dbo].[admin_user] (
  [admin_id] int  IDENTITY(1,1) NOT NULL,
  [user_name] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [admin_name] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [admin_phone] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [password] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [data_state] int  NULL
)
GO

ALTER TABLE [dbo].[admin_user] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for applicant
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[applicant]') AND type IN ('U'))
	DROP TABLE [dbo].[applicant]
GO

CREATE TABLE [dbo].[applicant] (
  [applicant_id] int  IDENTITY(1,1) NOT NULL,
  [applicant_name] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [sex] int  NULL,
  [applicant_phone] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [application_address] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [applicant_class] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [age] int  NULL,
  [id_number] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [password] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [user_name] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[applicant] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Auto increment value for admin_user
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[admin_user]', RESEED, 1)
GO


-- ----------------------------
-- Primary Key structure for table admin_user
-- ----------------------------
ALTER TABLE [dbo].[admin_user] ADD CONSTRAINT [PK_adminUser] PRIMARY KEY CLUSTERED ([admin_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Auto increment value for applicant
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[applicant]', RESEED, 1)
GO


-- ----------------------------
-- Primary Key structure for table applicant
-- ----------------------------
ALTER TABLE [dbo].[applicant] ADD CONSTRAINT [PK_applicant] PRIMARY KEY CLUSTERED ([applicant_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

