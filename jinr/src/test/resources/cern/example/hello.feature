Feature: Echo messages

  In order to demonstrate spring boot features
  I want to echo a message back

  Scenario: Echo without repeating

  Echo the response back as received

    Given a message
    When the message is sent without repeat
    Then the same message is returned

  @Wip
  Scenario: Echo with repeat

  Echo the response back as received twice

    Given a message
    When the message is sent with repeat
    Then the message is returned twice