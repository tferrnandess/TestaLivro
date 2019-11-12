$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri('testrunner\TestaLivros.feature');
formatter.feature({
  "line": 1,
  "name": "Test Book author",
  "description": "",
  "id": "test-book-author",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Check book author and compare it in another website",
  "description": "",
  "id": "test-book-author;check-book-author-and-compare-it-in-another-website",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I stay in website",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I search a book and author",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I save the information",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "I compare the author with result with another website",
  "keyword": "And "
});
formatter.match({
  "location": "StepsTestaLivros.SubBookPage()"
});
formatter.result({
  "duration": 44610252300,
  "status": "passed"
});
formatter.match({
  "location": "StepsTestaLivros.SearchBookAuthor()"
});
formatter.result({
  "duration": 501737600,
  "status": "passed"
});
formatter.match({
  "location": "StepsTestaLivros.SaveInformation()"
});
formatter.result({
  "duration": 294800,
  "status": "passed"
});
formatter.match({
  "location": "StepsTestaLivros.CompareInformation()"
});
formatter.result({
  "duration": 38169504400,
  "status": "passed"
});
});