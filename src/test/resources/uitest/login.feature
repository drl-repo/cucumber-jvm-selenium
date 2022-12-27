@login
Feature: Login functionality

	Scenario Outline: Login using '<case>' should get an error
	  Given i login page
	  When i type '<username>' and '<password>'
	  And i click login button
	  Then i should see '<error_message>'

	  Examples:
	    | case | username 	| password 	| error_message |
	    | empty username and password |    |    | Epic sadface: Username is required |
	    | empty password | whatever |	| Epic sadface: Password is required |
	    | invalid username and password | whatever	| whatever | Epic sadface: Username and password do not match any user in this service |
	    | invalid password  | standard_user | whatever | Epic sadface: Username and password do not match any user in this service |
	    | locked account | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out. |

	Scenario: Login using valid credentials
	  Given i login page
	  When i type 'standard_user' and 'secret_sauce'
	  And i click login button
	  Then i should see inventory page