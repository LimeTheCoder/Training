import com.limethecoder.infastructure.ApplicationContext;
import com.limethecoder.infastructure.Context;
import com.limethecoder.infastructure.InitialContext;
import com.limethecoder.infastructure.JavaConfig;
import com.limethecoder.repository.TweetRepository;


public class TweeterRunner {
    public static void main(String[] args) {
        Context context = new ApplicationContext(new JavaConfig());

        TweetRepository tweetRepository = context.getBean("tweetRepo");
        TweetRepository another = context.getBean("tweetRepo");

        System.out.println(another == tweetRepository);

        tweetRepository.findAll().forEach(System.out::println);
    }
}
