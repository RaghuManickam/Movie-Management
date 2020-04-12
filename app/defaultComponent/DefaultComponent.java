package defaultComponent;

import play.twirl.api.Html;

import javax.inject.Singleton;

@Singleton
public class DefaultComponent {
    Html footer = views.html.component.footer.render();

    public Html getFooter() {
        return footer;
    }

    public void setFooter(Html footer) {
        this.footer = footer;
    }
}
