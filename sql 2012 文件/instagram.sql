USE [master]
GO
/****** Object:  Database [instagram]    Script Date: 2016/11/9 22:24:59 ******/
CREATE DATABASE [instagram]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'instagram', FILENAME = N'E:\Microsoft SQLServer 2012\MSSQL11.MSSQLSERVER\MSSQL\DATA\instagram.mdf' , SIZE = 4160KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'instagram_log', FILENAME = N'E:\Microsoft SQLServer 2012\MSSQL11.MSSQLSERVER\MSSQL\DATA\instagram_log.ldf' , SIZE = 1040KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [instagram] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [instagram].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [instagram] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [instagram] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [instagram] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [instagram] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [instagram] SET ARITHABORT OFF 
GO
ALTER DATABASE [instagram] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [instagram] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [instagram] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [instagram] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [instagram] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [instagram] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [instagram] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [instagram] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [instagram] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [instagram] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [instagram] SET  ENABLE_BROKER 
GO
ALTER DATABASE [instagram] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [instagram] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [instagram] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [instagram] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [instagram] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [instagram] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [instagram] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [instagram] SET RECOVERY FULL 
GO
ALTER DATABASE [instagram] SET  MULTI_USER 
GO
ALTER DATABASE [instagram] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [instagram] SET DB_CHAINING OFF 
GO
ALTER DATABASE [instagram] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [instagram] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [instagram]
GO
/****** Object:  Table [dbo].[Comment]    Script Date: 2016/11/9 22:25:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Comment](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[note] [varchar](255) NULL,
	[picid] [int] NOT NULL,
	[userid] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Follow]    Script Date: 2016/11/9 22:25:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Follow](
	[createTime] [datetime2](7) NULL,
	[statue] [int] NOT NULL,
	[updateTime] [datetime2](7) NULL,
	[userid_userid] [varchar](255) NOT NULL,
	[f_userid_userid] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[userid_userid] ASC,
	[f_userid_userid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[like]    Script Date: 2016/11/9 22:25:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[like](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[picid] [int] NOT NULL,
	[userid] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Message]    Script Date: 2016/11/9 22:25:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Message](
	[msgid] [int] IDENTITY(1,1) NOT NULL,
	[isRead] [int] NOT NULL,
	[msgType] [varchar](255) NULL,
	[note] [varchar](255) NULL,
	[sendTime] [datetime2](7) NULL,
	[userid] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[msgid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Picture]    Script Date: 2016/11/9 22:25:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Picture](
	[picid] [int] IDENTITY(1,1) NOT NULL,
	[picpath] [varchar](255) NULL,
	[publishTime] [datetime2](7) NULL,
	[userid] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[picid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[user]    Script Date: 2016/11/9 22:25:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[user](
	[userid] [varchar](255) NOT NULL,
	[email] [varchar](255) NULL,
	[note] [varchar](255) NULL,
	[password] [varchar](255) NULL,
	[phone] [varchar](255) NULL,
	[portrait] [varchar](255) NULL,
	[sex] [varchar](255) NULL,
	[username] [varchar](255) NULL,
	[website] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[userid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD  CONSTRAINT [FK_lhyfdnf6t6vy8t9nqlkqywhie] FOREIGN KEY([userid])
REFERENCES [dbo].[user] ([userid])
GO
ALTER TABLE [dbo].[Comment] CHECK CONSTRAINT [FK_lhyfdnf6t6vy8t9nqlkqywhie]
GO
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD  CONSTRAINT [FK_lvpreea7pkkfw0mt1k6anitlj] FOREIGN KEY([picid])
REFERENCES [dbo].[Picture] ([picid])
GO
ALTER TABLE [dbo].[Comment] CHECK CONSTRAINT [FK_lvpreea7pkkfw0mt1k6anitlj]
GO
ALTER TABLE [dbo].[Follow]  WITH CHECK ADD  CONSTRAINT [FK_5qssu4aeev2aw0y9lr0m3uytf] FOREIGN KEY([f_userid_userid])
REFERENCES [dbo].[user] ([userid])
GO
ALTER TABLE [dbo].[Follow] CHECK CONSTRAINT [FK_5qssu4aeev2aw0y9lr0m3uytf]
GO
ALTER TABLE [dbo].[Follow]  WITH CHECK ADD  CONSTRAINT [FK_mhr69e3f9ggyy5r47h67uce94] FOREIGN KEY([userid_userid])
REFERENCES [dbo].[user] ([userid])
GO
ALTER TABLE [dbo].[Follow] CHECK CONSTRAINT [FK_mhr69e3f9ggyy5r47h67uce94]
GO
ALTER TABLE [dbo].[like]  WITH CHECK ADD  CONSTRAINT [FK_9bd3390rltb7qpchthqww5pdo] FOREIGN KEY([picid])
REFERENCES [dbo].[Picture] ([picid])
GO
ALTER TABLE [dbo].[like] CHECK CONSTRAINT [FK_9bd3390rltb7qpchthqww5pdo]
GO
ALTER TABLE [dbo].[like]  WITH CHECK ADD  CONSTRAINT [FK_pbwm7i2lkl1wmaj2tfyxc8dkj] FOREIGN KEY([userid])
REFERENCES [dbo].[user] ([userid])
GO
ALTER TABLE [dbo].[like] CHECK CONSTRAINT [FK_pbwm7i2lkl1wmaj2tfyxc8dkj]
GO
ALTER TABLE [dbo].[Message]  WITH CHECK ADD  CONSTRAINT [FK_tn052tq19f9apkfwsfdtm5d25] FOREIGN KEY([userid])
REFERENCES [dbo].[user] ([userid])
GO
ALTER TABLE [dbo].[Message] CHECK CONSTRAINT [FK_tn052tq19f9apkfwsfdtm5d25]
GO
ALTER TABLE [dbo].[Picture]  WITH CHECK ADD  CONSTRAINT [FK_48h582f7xmv6sihcm5toemrhj] FOREIGN KEY([userid])
REFERENCES [dbo].[user] ([userid])
GO
ALTER TABLE [dbo].[Picture] CHECK CONSTRAINT [FK_48h582f7xmv6sihcm5toemrhj]
GO
USE [master]
GO
ALTER DATABASE [instagram] SET  READ_WRITE 
GO
