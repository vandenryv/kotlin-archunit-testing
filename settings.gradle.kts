plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

include("domain")
include("database")
include("common")
rootProject.name = "HexaVote"
include("api")
