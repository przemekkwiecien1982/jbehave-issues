package defects;

import defects.steps.DummyFastSteps;
import defects.steps.DummySteps;
import defects.steps.LoginSteps;
import org.apache.log4j.Logger;
import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import static org.jbehave.core.reporters.Format.*;

/**
 * Created by Przemek Kwiecien on 2014-08-18.
 */
public class GivenStoriesStories extends JUnitStories {
    private Logger log =Logger.getLogger("dummy.test");

    public GivenStoriesStories() {
        configuredEmbedder().embedderControls().doGenerateViewAfterStories(true).doIgnoreFailureInStories(false)
                .doIgnoreFailureInView(true).useThreads(1).useStoryTimeoutInSecs(15);
        log.info("Log initialized");
    }

    @Override
    public Configuration configuration() {
        Class<? extends Embeddable> embeddableClass = this.getClass();
        // Start from default ParameterConverters instance
        ParameterConverters parameterConverters = new ParameterConverters();
        // factory to allow parameter conversion and loading from external resources (used by StoryParser too)
        ExamplesTableFactory examplesTableFactory = new ExamplesTableFactory(new LocalizedKeywords(), new LoadFromClasspath(embeddableClass), parameterConverters);
        // add custom converters
        parameterConverters.addConverters(new ParameterConverters.DateConverter(new SimpleDateFormat("yyyy-MM-dd")),
                new ParameterConverters.ExamplesTableConverter(examplesTableFactory));
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(embeddableClass))
                .useStoryParser(new RegexStoryParser(examplesTableFactory))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
                        .withDefaultFormats()
                        .withFormats(CONSOLE, TXT, HTML, XML)
                        .withFailureTrace(true)
                        .withFailureTraceCompression(false))
                .useParameterConverters(parameterConverters);
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new DummyFastSteps(log));
    }

    @Override
    protected List<String> storyPaths() {
        //return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/*.story", "**/excluded*.story");
        return Arrays.asList("defects/stories/givenstories/givenStories.story");

    }

}
