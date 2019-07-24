$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("classpath:myapppackage/excelTest.feature");
formatter.feature({
  "name": "ExcelTest",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Excel"
    }
  ]
});
formatter.scenario({
  "name": "Create and Save Excel Document",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Excel"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have opened a blank workbook",
  "keyword": "Given "
});
formatter.match({
  "location": "ExcelStepDefs.i_have_opened_a_blank_workbook()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter text into cell BFour",
  "keyword": "When "
});
formatter.match({
  "location": "ExcelStepDefs.i_enter_text_into_cell_BFour()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "save the workbook",
  "keyword": "And "
});
formatter.match({
  "location": "ExcelStepDefs.save_the_workbook()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the entered text is retained in cell BFour",
  "keyword": "Then "
});
formatter.match({
  "location": "ExcelStepDefs.the_entered_text_is_retained_in_cell_BFour()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Update and Save Excel Document",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Excel"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have created and saved a Excel Document",
  "keyword": "Given "
});
formatter.match({
  "location": "ExcelStepDefs.i_have_created_and_saved_a_Excel_Document()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I update by entering text into cell DNine",
  "keyword": "When "
});
formatter.match({
  "location": "ExcelStepDefs.i_update_by_entering_text_into_cell_DNine()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "save the workbook using existing filename",
  "keyword": "And "
});
formatter.match({
  "location": "ExcelStepDefs.save_the_workbook_using_existing_filename()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the updated text is retained in Cell DNine",
  "keyword": "Then "
});
formatter.match({
  "location": "ExcelStepDefs.the_updated_text_is_retained_in_Cell_DNine()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});