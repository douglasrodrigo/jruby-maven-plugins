package de.saumya.mojo.gem;

import java.io.IOException;

import org.apache.maven.plugin.MojoExecutionException;

import de.saumya.mojo.jruby.AbstractJRubyMojo;
import de.saumya.mojo.ruby.script.ScriptException;

/**
 * Deprecated: just not really needed, use "gem:gem -Dargs=spec" instead
 * goal to run "gem spec".
 * 
 * @goal spec
 */
@Deprecated
public class SpecMojo extends AbstractJRubyMojo {
    /**
     * arguments for the gem command of JRuby.
     * 
     * @parameter default-value="${gemfile}"
     */
    protected String gemfile = null;

    @Override
    public void executeJRuby() throws MojoExecutionException,
            ScriptException, IOException {
        if (this.gemfile == null) {
            getLog().warn("please specifiy a gem file, use '-Dgemfile=...'");
        }
        else {
            this.factory.newScriptFromJRubyJar("gem")
                    .addArg("spec")
                    .addArgs(this.gemfile)
                    .addArgs(this.args)
                    .execute();
        }
    }
}
