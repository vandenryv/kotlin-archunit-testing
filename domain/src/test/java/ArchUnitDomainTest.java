import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.hexavote.domain.VoteService;

@AnalyzeClasses(packagesOf = VoteService.class)
public class ArchUnitDomainTest {

  @ArchTest
  public static final ArchRule rule_as_field = ArchRuleDefinition.noClasses()
      .that().resideInAPackage("org.hexavote.domain")
      .should().dependOnClassesThat()
      .resideOutsideOfPackages(
          "org.hexavote.domain..",
          "..common..",
          "java..", // List and stuff
          "kotlin..", // Kotlin stuff
          "org.jetbrains.." // Adaptive layer between Kotlin and JVMs
      );
  @ArchTest
  public static final ArchRule portNamingAndTyping = ArchRuleDefinition.classes()
      .that().resideInAnyPackage("..port.in..", "..port.out..")
      .should().haveSimpleNameEndingWith("Port")
      .andShould().beInterfaces();

  @ArchTest
  public static void rule_as_method(JavaClasses classes) {
    var rule = ArchRuleDefinition.noClasses()
        .that().resideInAPackage("org.hexavote.domain")
        .should().dependOnClassesThat()
        .resideOutsideOfPackages(
            "org.hexavote.domain..",
            "..common..",
            "java..", // List and stuff
            "kotlin..", // Kotlin stuff
            "org.jetbrains.." // Adaptive layer between Kotlin and JVMs
        );
    rule.check(classes);
  }
}
