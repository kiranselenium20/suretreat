
Feature: Pool Manager test scenarios

Scenario:01_Successful login with valid credentials
	Given I Open the suretreat application
	When  I click on " Log In " button
	And   I Enter email as "Kiran_User@yopmail.com"
	And   I Enter password as "Test@123"
	And   I Scroll Down
  When  I click on " Login " button
  And   I click on " Quick Test " button
  And   I Scroll Down of the page
  And   I click on "  RUN TEST " button
  And   I click on "Run Manual Test" button
  When  I Enter the value "5" in field "pH"
  And   I Enter the value "80" in field "Calcium Hardness"
  And   I Scroll Middle
  When  I Select "Eye" Radio button
  When  I Select "Green haze" Radio button
  And   I Scroll Down
  When  I click on "Report" button
  Then  I Should see the "PH" value as "7 pH"
  And   I Should see the " CALCIUM HARDNESS" value as "80 ppm"
  And   I Should see below details
         |Condition            |Recommendation                                                                                                                               |Product|
         |Total hardness is low|Total hardness levels are too low. Consult your pool and spa dealer for advice about correcting this condition.                              |2643.8 lbs of Calcium Hardness|
         |pH is low            |The pH level is too low. Low pH can lead to aggressive water that may damage equipment and surfaces. Add the recommended treatment product(s) to raise pH to the acceptable range., Raising the pH will likely affect the total alkalinity. Retest both parameters after the pH treatment has circulated to determine if additional treatment is required.|1.3 lbs of Soda Ash|
         |- Consult your pool and spa dealer for help with eye irritation reduction.|Consult your pool and spa dealer for help with eye irritation reduction.|1.0 lbs of Oxidizer|
         |- Consult your pool and spa dealer for help with green algae removal.|Consult your pool and spa dealer for help with green algae removal.|40 oz of Algae Kill,10 oz of All Purpose Algaecide,16 oz of Concentrated Algaecide 60,4 oz of Green Algaecide|
  And  I Scroll Up of the Page
  And  I logout of the application
  
 Scenario:02_Successful login with valid another credentials
  Given I Login with email as "Kiran_User@yopmail.com" and Password as "Test@123"
	And   I Scroll Down
  When  I click on " Login " button
  And   I click on " Quick Test " button
  And   I Scroll Down of the page
  And   I click on "  RUN TEST " button
  And   I click on "Run Manual Test" button
  When  I Enter the value "5" in field "Acid Demand"
  And   I Enter the value "80" in field "Calcium Hardness"
  And   I Enter the value "120" in field "Total Alkalinity"
  And   I Scroll Middle
  When  I Select " Cloudy / Hazy " Radio button
  And   I Select " Dirty / Muddy " Radio button
  And   I Scroll Down
  And   I Select " Blue-Green " Radio button
  And   I Select " Crystal Clear Water " Radio button
  When  I click on "Report" button
  And   I Should see below details
         |Condition            |Recommendation                                                                                                                               |Product|
         |Total hardness is low|Total hardness levels are too low. Consult your pool and spa dealer for advice about correcting this condition.                              |2643.8 lbs of Calcium Hardness|
         |- Consult your pool and spa dealer for help with water clarification.|Consult your pool and spa dealer for help with water clarification.|2 oz of Clarifier,1.0 lbs of Oxidizer,6 oz of Shock Booster|
  And   I Scroll Middle
  And   I Should see below details
         |Condition            |Recommendation                                                                                                   |Product|
         |- Consult your pool and spa dealer for help with dirt / mud removal.|Consult your pool and spa dealer for help with dirt / mud removal.|       |
         |Clear water maintenance|Consult your pool and spa dealer for information about maintaining your water crystal clear.|                          |
  And  I Scroll Up of the Page
  And  I logout of the application
  
  Scenario:03_Successful login with valid another credentials
  Given I Login with email as "Kiran_User@yopmail.com" and Password as "Test@123"
	And   I Scroll Down
  When  I click on " Login " button
  And   I click on " Quick Test " button
  And   I Scroll Down of the page
  And   I click on "  RUN TEST " button
  And   I click on "Run Manual Test" button
  When  I Enter the value "120" in field "Iron"
  And   I Enter the value "85" in field "Calcium Hardness"
  And   I Enter the value "70" in field "Total Alkalinity"
  And   I Enter the value "100" in field "Temperature"
  And   I Enter the value "60" in field "Free Chlorine"
  And   I Scroll Middle
  And   I Select " Dirty / Muddy " Radio button
  And   I Scroll Down
  And   I Select " Blue-Green " Radio button
  And   I Select " Water Foaming " Radio button
  And   I Select " Filter Cleaning " Radio button
  When  I click on "Report" button
  Then  I Should see the "PH" value as "7 pH"
  And   I Should see the " CALCIUM HARDNESS" value as "85 ppm"
  And   I Should see the " IRON" value as "120 ppm"
  And   I Should see the "  TOTAL ALKALINITY" value as "70 ppm"
  And   I Scroll Middle
 # And   I Should see the " TEMPERATURE" value as " 100 °F "
  And   I Should see below details
         |Condition            |Recommendation                                                                                                                               |Product|
         |TA is low| The total alkalinity level is too low. An appropriate level of total alkalinity is needed to maintain a stable pH., Add the recommended treatment product(s) to raise total alkalinity to the acceptable range., NOTE: Adjusting total alkalinity will likely affect pH, so retest both parameters after the total alkalinity treatment has circulated to determine if additional treatment is required.|0.042 lbs of Alkalinity,ABC, PRODUCT INSTRUCTIONS, Test ABC|
         |Total hardness is low|Total hardness levels are too low. Consult your pool and spa dealer for advice about correcting this condition.                              |2583.8 lbs of Calcium Hardness|
         |pH is low            |The pH level is too low. Low pH can lead to aggressive water that may damage equipment and surfaces. Add the recommended treatment product(s) to raise pH to the acceptable range., Raising the pH will likely affect the total alkalinity. Retest both parameters after the pH treatment has circulated to determine if additional treatment is required.|0.62 lbs of Soda Ash|
  And  I Scroll Up of the Page
  And  I logout of the application
  
  
  