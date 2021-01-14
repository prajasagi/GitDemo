Feature: Netflix Testing

Scenario Outline: Netflix Login Validation
Given Initialize the browser with Chrome
When Validate Netflix login with username <username> password <password> and <text> validations
Then Close all applications

Examples:
|username|password|text|
|pavan@gmail.com|543534|RestrictedUser|
|kumar@gmail.com|674234|NonRestrictedUser|
|varma@gmail.com|964534|RestrictedUser|