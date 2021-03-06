package de.saumya.mojo.runit;

public class Runit18MavenTestScriptFactory extends AbstractRunitMavenTestScriptFactory {

    @Override
    void getTestRunnerScript(StringBuilder builder) {
        builder.append("require 'test/unit/ui/console/testrunner'\n");
        builder.append("class Test::Unit::UI::Console::TestRunner\n");
        builder.append("    extend Test::Unit::UI::TestRunnerUtilities\n");
        builder.append("  alias :old_initialize :initialize\n");
        builder.append("  def initialize(suite, output_level=NORMAL)\n");
        builder.append("    old_initialize(suite, output_level, Tee.open(REPORT_PATH, 'w'))\n");
        builder.append("  end\n");
        builder.append("end\n");
    }

    @Override
    protected String getScriptName() {
        return "test-runner.rb";
    }

}
