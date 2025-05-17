@registration
Feature: User Registration

  # Scenario 1: Navigate to Registration form
  Scenario: Check registration form link
    Given I Click on the Registration Form link
    When I fill out the registration form and submit
    Then I should see the registration success message

  # Scenario 2: Validate mandatory field error messages
  @mandatoryFields
  Scenario: Validate that mandatory fields show error message
    Given I Click on the Registration Form link
    When I leave the email, password, and confirm password fields blank and click submit button
    Then I should see the 'This field is required.' message for email, user password, and confirm password

  # Scenario 3: Complete registration and validate success message
  @validRegistration
  Scenario: Validate user registration
    #Given I Click on the Registration Form link
    When I enter all the details and click submit button
    Then I should see the success message
