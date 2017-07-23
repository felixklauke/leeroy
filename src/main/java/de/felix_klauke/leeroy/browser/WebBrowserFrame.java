/*
 * Copyright (c) 2017 Felix Klauke
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.felix_klauke.leeroy.browser;

import de.felix_klauke.leeroy.browser.listener.BrowseActionListener;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * @author Felix 'SasukeKawaii' Klauke
 */
public class WebBrowserFrame extends JFrame {

    private final JTextField urlField;
    private final JEditorPane content;
    private final JLabel status;

    public WebBrowserFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.urlField = new JTextField();
        this.content = new JEditorPane();
        this.status = new JLabel(" ");

        urlField.addActionListener(new BrowseActionListener(this));

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel("URL: "), BorderLayout.WEST);
        panel.add(urlField, BorderLayout.CENTER);

        Container currentContainer = getContentPane();
        currentContainer.add(panel, BorderLayout.NORTH);
        currentContainer.add(content, BorderLayout.CENTER);
        currentContainer.add(status, BorderLayout.SOUTH);

        setSize(300, 300);
        setVisible(true);
    }

    public void openURL(String url) {
        try {
            this.content.setPage(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
