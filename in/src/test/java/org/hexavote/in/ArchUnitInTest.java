package org.hexavote.in;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

@AnalyzeClasses(packagesOf = VoteController.class)
public interface ArchUnitInTest {
  @ArchTest
  public static void in_does_not_depend_on_out(JavaClasses classes) {
    ArchRuleDefinition.noClasses()
        .that().resideInAPackage("org.hexavote.in")
        .should().dependOnClassesThat()
        .resideOutsideOfPackages(
            "..out.."
        ).check(classes);
  }

}
