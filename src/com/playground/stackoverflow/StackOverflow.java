package com.playground.stackoverflow;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * User: liviu
 * Date: 1/15/14
 * Time: 11:01 PM
 */
public class StackOverflow {

    public static void main(String... args) throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {
        sound();
        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag("jsoup"));
        tags.add(new Tag("spring-batch"));
        tags.add(new Tag("multithreading+java"));
        tags.add(new Tag("thread-safety+java"));
        while (true) {
            for (Tag tag : tags) {
                tag.scan();
            }
            Thread.sleep(TimeUnit.SECONDS.toMillis(10));
        }
    }

    private static void sound() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        for (int i = 0; i < 3; i++) {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("a13-problem.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            long millis = clip.getMicrosecondLength() / 1000;
            Thread.sleep(millis);
        }
    }

    public static class Tag {

        public static final String HTTP_STACKOVERFLOW_COM = "http://stackoverflow.com";
        public final String tag;

        public final Set<String> prev;

        public Tag(String tag) {
            this.tag = tag;
            prev = new HashSet<>();
        }

        private void scan() throws IOException, UnsupportedAudioFileException, InterruptedException, LineUnavailableException {
            Document doc = Jsoup.connect(String.format(HTTP_STACKOVERFLOW_COM + "/questions/tagged/%s", tag)).get();
            Elements select = doc.select("div[id*=question-summary]");
            boolean firstRun = prev.isEmpty();
            for (Element element : select) {
                Elements q = element.select("a.question-hyperlink");
                String text = q.get(0).text();
                if (firstRun) {
                    prev.add(text);
                } else {
                    if (prev.add(text)) {
                        System.out.println("New Question " + tag);
                        System.out.println(text);
                        System.out.println(HTTP_STACKOVERFLOW_COM + q.get(0).attr("href"));
                        sound();
                    }
                }
            }
        }

    }
}