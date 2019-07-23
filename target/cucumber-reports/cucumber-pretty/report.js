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
  "error_message": "java.lang.NullPointerException\r\n\tat myapppackage.pageObjects.BasePage.Find(BasePage.java:26)\r\n\tat myapppackage.pageObjects.ChromeApp.getCurrentUrl(ChromeApp.java:46)\r\n\tat myapppackage.StepDefintions.ChromeStepDefs.the_expected_home_page_is_displayed(ChromeStepDefs.java:31)\r\n\tat ✽.the expected home page is displayed(classpath:myapppackage/chromeTest.feature:6)\r\n",
  "status": "failed"
});
formatter.after({
  "error_message": "java.lang.NullPointerException\r\n\tat myapppackage.Hooks.AfterTestRun(Hooks.java:61)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\r\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\r\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:63)\r\n\tat cucumber.runner.TestStep.run(TestStep.java:49)\r\n\tat cucumber.runner.TestCase.run(TestCase.java:49)\r\n\tat cucumber.runner.Runner.runPickle(Runner.java:40)\r\n\tat cucumber.runtime.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:68)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:23)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:73)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:122)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:64)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat cucumber.api.junit.Cucumber$1.evaluate(Cucumber.java:131)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.execute(JUnit4Provider.java:283)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.executeWithRerun(JUnit4Provider.java:173)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.executeTestSet(JUnit4Provider.java:153)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.invoke(JUnit4Provider.java:128)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.invokeProviderInSameClassLoader(ForkedBooter.java:203)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:155)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:103)\r\n",
  "status": "failed"
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
});