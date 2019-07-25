$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("classpath:myapppackage/chromeTest.feature");
formatter.feature({
  "name": "ChromeTest",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Chrome"
    }
  ]
});
formatter.scenario({
  "name": "Chrome home page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Chrome"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "that Chrome has opened",
  "keyword": "Given "
});
formatter.match({
  "location": "ChromeStepDefs.that_Chrome_has_opened()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the expected home page is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "ChromeStepDefs.the_expected_home_page_is_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Chrome navigate to other site",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Chrome"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "that Chrome has opened",
  "keyword": "Given "
});
formatter.match({
  "location": "ChromeStepDefs.that_Chrome_has_opened()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I attempt to navigate to another site",
  "keyword": "When "
});
formatter.match({
  "location": "ChromeStepDefs.i_attempt_to_navigate_to_another_site()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the expected site is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "ChromeStepDefs.the_expected_site_is_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("classpath:myapppackage/excelTest.feature");
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
formatter.uri("classpath:myapppackage/ie11Test.feature");
formatter.feature({
  "name": "IETest",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@ie"
    }
  ]
});
formatter.scenario({
  "name": "IE11 home page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@ie"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "that IE has opened",
  "keyword": "Given "
});
formatter.match({
  "location": "Ie11StepDefs.that_IE_has_opened()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the expected home page is displayed in IE",
  "keyword": "Then "
});
formatter.match({
  "location": "Ie11StepDefs.the_expected_home_page_is_displayed_in_IE()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "IE11 navigate to other site",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@ie"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "that IE has opened",
  "keyword": "Given "
});
formatter.match({
  "location": "Ie11StepDefs.that_IE_has_opened()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I attempt to navigate to another site in IE",
  "keyword": "When "
});
formatter.match({
  "location": "Ie11StepDefs.i_attempt_to_navigate_to_another_site_in_IE()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the expected site is displayed in IE",
  "keyword": "Then "
});
formatter.match({
  "location": "Ie11StepDefs.the_expected_site_is_displayed_in_IE()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("classpath:myapppackage/msWordTest.feature");
formatter.feature({
  "name": "WordTest",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Word"
    }
  ]
});
formatter.scenario({
  "name": "Create and Save Word Document",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Word"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have opened Word",
  "keyword": "Given "
});
formatter.match({
  "location": "WordStepDefs.i_have_opened_Word()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter text",
  "keyword": "When "
});
formatter.match({
  "location": "WordStepDefs.i_enter_text()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "save the document",
  "keyword": "And "
});
formatter.match({
  "location": "WordStepDefs.save_the_document()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the entered text is retained",
  "keyword": "Then "
});
formatter.match({
  "location": "WordStepDefs.the_entered_text_is_retained()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Update and Save Word Document",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Word"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have created and saved a Word Document",
  "keyword": "Given "
});
formatter.match({
  "location": "WordStepDefs.i_have_created_and_saved_a_Word_Document()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I update the text",
  "keyword": "When "
});
formatter.match({
  "location": "WordStepDefs.i_update_the_text()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "save the document using existing filename",
  "keyword": "And "
});
formatter.match({
  "location": "WordStepDefs.save_the_document_using_existing_filename()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the updated text is retained",
  "keyword": "Then "
});
formatter.match({
  "location": "WordStepDefs.the_updated_text_is_retained()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("classpath:myapppackage/powerpointTest.feature");
formatter.feature({
  "name": "PowerPointTest",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Powerpoint"
    }
  ]
});
formatter.scenario({
  "name": "Create and Save Powerpoint file with added slide",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Powerpoint"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have opened Powerpoint",
  "keyword": "Given "
});
formatter.match({
  "location": "PowerpointStepDefs.i_have_opened_Powerpoint()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add a slide to the Powerpoint file",
  "keyword": "When "
});
formatter.match({
  "location": "PowerpointStepDefs.i_add_a_slide_to_the_Powerpoint_file()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "save the Powerpoint file",
  "keyword": "And "
});
formatter.match({
  "location": "PowerpointStepDefs.save_the_Powerpoint_file()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the added slide is retained",
  "keyword": "Then "
});
formatter.match({
  "location": "PowerpointStepDefs.the_added_slide_is_retained()"
});
formatter.result({
  "error_message": "java.lang.AssertionError\r\n\tat org.junit.Assert.fail(Assert.java:86)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat org.junit.Assert.assertTrue(Assert.java:52)\r\n\tat myapppackage.StepDefintions.PowerpointStepDefs.the_added_slide_is_retained(PowerpointStepDefs.java:100)\r\n\tat ✽.the added slide is retained(classpath:myapppackage/powerpointTest.feature:22)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("classpath:myapppackage/theEdgeTest.feature");
formatter.feature({
  "name": "EdgeTest",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@edge"
    }
  ]
});
formatter.scenario({
  "name": "Edge home page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@edge"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "that Edge has opened",
  "keyword": "Given "
});
formatter.match({
  "location": "EdgeStepDefs.that_Edge_has_opened()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the expected home page is displayed in Edge",
  "keyword": "Then "
});
formatter.match({
  "location": "EdgeStepDefs.the_expected_home_page_is_displayed_in_Edge()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Edge navigate to other site",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@edge"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "that Edge has opened",
  "keyword": "Given "
});
formatter.match({
  "location": "EdgeStepDefs.that_Edge_has_opened()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I attempt to navigate to another site in Edge",
  "keyword": "When "
});
formatter.match({
  "location": "EdgeStepDefs.i_attempt_to_navigate_to_another_site_in_Edge()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the expected site is displayed in Edge",
  "keyword": "Then "
});
formatter.match({
  "location": "EdgeStepDefs.the_expected_site_is_displayed_in_Edge()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});