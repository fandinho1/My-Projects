@tag
Feature: Monster creation
  As a user I want to create mosnters and see its details in my monster space

  @smokeTest
  Scenario Outline: creation of mosnter successfully
    Given the user is on monster page
    When he creates a monster
      | name   | hp   | attack   | defense   | speed   | monsterImg   |
      | <name> | <hp> | <attack> | <defense> | <speed> | <monsterImg> |
    Then he should see the monster created correctly
      | name   | hp   | attack   | defense   | speed   | monsterImg   |
      | <name> | <hp> | <attack> | <defense> | <speed> | <monsterImg> |
    When he delete the monster created
    Then he should not see monsters in his space

    Examples: 
      | name     | hp | attack | defense | speed | monsterImg   |
      | unicorn1 |  5 |     67 |      34 |     3 | dead-unicorn |
      | shark1   | 57 |     27 |      14 |    33 | old-shark    |
      | dragon1  | 15 |     71 |      94 |    32 | red-dragon   |
      | bear1    | 54 |     63 |       4 |    35 | robot-bear   |
      | snake1   | 79 |     77 |      45 |    38 | angry-snake  |
