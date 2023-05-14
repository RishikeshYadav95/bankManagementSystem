-- Create database
CREATE DATABASE IF NOT EXISTS bank_management_system;

-- Use database
USE bank_management_system;

-- Create required tables
CREATE TABLE IF NOT EXISTS Customer(formno varchar(20), cardNumber varchar(20), pin varchar(10), name varchar(50), ssn varchar(20), passportNo varchar(20), fname varchar(50), dob varchar(20), gender varchar(10), email varchar(100), mariatal varchar(10), address varchar(100), city varchar(20), state varchar(20), zip varchar(10), race varchar(100), category varchar(20), income varchar(100), education varchar(100), occupation varchar(100), seniorCitizen varchar(10), existAcnt varchar(10), acountType varchar(30), atmCard varchar(2), chequeBook varchar(2), internetBanking varchar(2), mobileBanking varchar(2), eStatement varchar(2), emailSMS varchar(2));

CREATE TABLE IF NOT EXISTS Login(ssn varchar(20), cardNumber varchar(20), pin varchar(10));

CREATE TABLE IF NOT EXISTS Transactions(ssn varchar(20), amount varchar(50), type varchar(30), date varchar(50)); 

CREATE TABLE IF NOT EXISTS Accounts(ssn varchar(20), balance varchar(100));
