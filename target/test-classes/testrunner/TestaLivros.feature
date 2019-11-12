Feature: Test Book author

Scenario: Check book author and compare it in another website

Given I stay in website

When I search a book and author

Then I save the information

And I compare the author with result with another website