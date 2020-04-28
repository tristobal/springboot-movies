package com.ido.movies.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

public class LayeredArchitectureTests {
    @Test
    void controllerPublicMethodsShouldReturnLists() {

        JavaClasses importedClasses = new ClassFileImporter()
                .withImportOption(new ImportOption.DoNotIncludeTests())
                .importPackages("com.ido.movies");

        ArchRule myRule = layeredArchitecture()
                .layer("Controllers").definedBy("..com.ido.movies.controller..")
                .layer("Services").definedBy("..com.ido.movies.service..")
                .whereLayer("Controllers").mayNotBeAccessedByAnyLayer()
                .whereLayer("Services").mayOnlyBeAccessedByLayers("Controllers");

        myRule.check(importedClasses);
    }
}
