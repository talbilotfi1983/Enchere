USE [master]
GO

/****** Object:  Database [DB_ENCHERE]    Script Date: 10/06/2021 15:56:18 ******/
CREATE DATABASE [DB_ENCHERE]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DB_ENCHERE', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.TESTCONNECT\MSSQL\DATA\DB_ENCHERE.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'DB_ENCHERE_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.TESTCONNECT\MSSQL\DATA\DB_ENCHERE_log.ldf' , SIZE = 2048KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DB_ENCHERE].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

ALTER DATABASE [DB_ENCHERE] SET ANSI_NULL_DEFAULT OFF 
GO

ALTER DATABASE [DB_ENCHERE] SET ANSI_NULLS OFF 
GO

ALTER DATABASE [DB_ENCHERE] SET ANSI_PADDING OFF 
GO

ALTER DATABASE [DB_ENCHERE] SET ANSI_WARNINGS OFF 
GO

ALTER DATABASE [DB_ENCHERE] SET ARITHABORT OFF 
GO

ALTER DATABASE [DB_ENCHERE] SET AUTO_CLOSE OFF 
GO

ALTER DATABASE [DB_ENCHERE] SET AUTO_SHRINK OFF 
GO

ALTER DATABASE [DB_ENCHERE] SET AUTO_UPDATE_STATISTICS ON 
GO

ALTER DATABASE [DB_ENCHERE] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO

ALTER DATABASE [DB_ENCHERE] SET CURSOR_DEFAULT  GLOBAL 
GO

ALTER DATABASE [DB_ENCHERE] SET CONCAT_NULL_YIELDS_NULL OFF 
GO

ALTER DATABASE [DB_ENCHERE] SET NUMERIC_ROUNDABORT OFF 
GO

ALTER DATABASE [DB_ENCHERE] SET QUOTED_IDENTIFIER OFF 
GO

ALTER DATABASE [DB_ENCHERE] SET RECURSIVE_TRIGGERS OFF 
GO

ALTER DATABASE [DB_ENCHERE] SET  DISABLE_BROKER 
GO

ALTER DATABASE [DB_ENCHERE] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO

ALTER DATABASE [DB_ENCHERE] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO

ALTER DATABASE [DB_ENCHERE] SET TRUSTWORTHY OFF 
GO

ALTER DATABASE [DB_ENCHERE] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO

ALTER DATABASE [DB_ENCHERE] SET PARAMETERIZATION SIMPLE 
GO

ALTER DATABASE [DB_ENCHERE] SET READ_COMMITTED_SNAPSHOT OFF 
GO

ALTER DATABASE [DB_ENCHERE] SET HONOR_BROKER_PRIORITY OFF 
GO

ALTER DATABASE [DB_ENCHERE] SET RECOVERY SIMPLE 
GO

ALTER DATABASE [DB_ENCHERE] SET  MULTI_USER 
GO

ALTER DATABASE [DB_ENCHERE] SET PAGE_VERIFY CHECKSUM  
GO

ALTER DATABASE [DB_ENCHERE] SET DB_CHAINING OFF 
GO

ALTER DATABASE [DB_ENCHERE] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO

ALTER DATABASE [DB_ENCHERE] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO

ALTER DATABASE [DB_ENCHERE] SET DELAYED_DURABILITY = DISABLED 
GO

ALTER DATABASE [DB_ENCHERE] SET  READ_WRITE 
GO


