/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyconverter;

import java.io.IOException;
import java.io.InputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.io.StreamConnection;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author timur
 */
public class CurrencyConverter extends MIDlet implements CommandListener {
    
    private boolean midletPaused = false;

    private int currenChoosable = 0;
    
//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command exitCommand;
    private Command chooseCurrencyFrom;
    private Command chooseCurrencyTo;
    private Command chooseOkCommand;
    private Command backCommand;
    private Command convertOkCommand;
    private Command showCurrenciesItemCommand;
    private Form form;
    private StringItem stringItem;
    private StringItem stringItem1;
    private StringItem stringItem2;
    private TextField textField;
    private List list;
//</editor-fold>//GEN-END:|fields|0|

    /**
     * The HelloMIDlet constructor.
     */
    public CurrencyConverter() {
    }

//<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
//</editor-fold>//GEN-END:|methods|0|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initializes the application. It is called only once when the MIDlet is
     * started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {
//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
}//GEN-BEGIN:|0-initialize|2|
//</editor-fold>//GEN-END:|0-initialize|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {
//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
switchDisplayable(null, getForm());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
}//GEN-BEGIN:|3-startMIDlet|2|
//</editor-fold>//GEN-END:|3-startMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {
//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
}//GEN-BEGIN:|4-resumeMIDlet|2|
//</editor-fold>//GEN-END:|4-resumeMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code>
     * instance is taken from <code>getDisplay</code> method. This method is
     * used by all actions in the design for switching displayable.
     *
     * @param alert the Alert which is temporarily set to the display; if
     * <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {
//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
}//GEN-BEGIN:|5-switchDisplayable|2|
//</editor-fold>//GEN-END:|5-switchDisplayable|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a
     * particular displayable.
     *
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {
//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
if (command == backToFormCommand) {
    switchDisplayable(null, getForm());
}

if (displayable == form) {//GEN-BEGIN:|7-commandAction|1|27-preAction
            if (command == chooseCurrencyFrom) {//GEN-END:|7-commandAction|1|27-preAction
                
                currenChoosable = 1;

// write pre-action user code here
switchDisplayable(null, getList());//GEN-LINE:|7-commandAction|2|27-postAction

                if (list.size() == 0) {
                    fillCurrenciesList();
                }

// write post-action user code here
} else if (command == chooseCurrencyTo) {//GEN-LINE:|7-commandAction|3|29-preAction
 // write pre-action user code here
                currenChoosable = 2;
    
                switchDisplayable(null, getList());//GEN-LINE:|7-commandAction|4|29-postAction

                if (list.size() == 0) {
                    fillCurrenciesList();
                }

// write post-action user code here
} else if (command == convertOkCommand) {//GEN-LINE:|7-commandAction|5|39-preAction
 // write pre-action user code here
    new Thread(new Runnable(){
        public void run() {
            String s;
            s = stringItem1.getText();
            String fromCurrencyCode = s.substring(s.indexOf("(") + 1, s.indexOf("(") + 4);
            s = stringItem2.getText();
            String toCurrencyCode = s.substring(s.indexOf("(") + 1, s.indexOf("(") + 4);
            stringItem.setText(getConvertedValue(fromCurrencyCode, toCurrencyCode, textField.getString(), true));
        }
    }).start();
//GEN-LINE:|7-commandAction|6|39-postAction
 // write post-action user code here
} else if (command == exitCommand) {//GEN-LINE:|7-commandAction|7|19-preAction
                // write pre-action user code here
exitMIDlet();//GEN-LINE:|7-commandAction|8|19-postAction
                // write post-action user code here
} else if (command == showCurrenciesItemCommand) {//GEN-LINE:|7-commandAction|9|44-preAction
 // write pre-action user code here
    switchDisplayable(null, getCurrenciesGraph());
//GEN-LINE:|7-commandAction|10|44-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|11|24-preAction
} else if (displayable == list) {
    if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|11|24-preAction
 // write pre-action user code here
listAction();//GEN-LINE:|7-commandAction|12|24-postAction
 // write post-action user code here
} else if (command == backCommand) {//GEN-LINE:|7-commandAction|13|35-preAction
 // write pre-action user code here
switchDisplayable(null, getForm());//GEN-LINE:|7-commandAction|14|35-postAction
 // write post-action user code here
} else if (command == chooseOkCommand) {//GEN-LINE:|7-commandAction|15|32-preAction
 // write pre-action user code here
    
    switch (currenChoosable) {
        case 1:
            stringItem1.setText(list.getString(list.getSelectedIndex()));
            break;
        case 2:
            stringItem2.setText(list.getString(list.getSelectedIndex()));
            break;
    }
    
        switchDisplayable(null, getForm());//GEN-LINE:|7-commandAction|16|32-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|17|7-postCommandAction
        }//GEN-END:|7-commandAction|17|7-postCommandAction
        // write post-action user code here
}//GEN-BEGIN:|7-commandAction|18|
//</editor-fold>//GEN-END:|7-commandAction|18|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initialized instance of exitCommand component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {
//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
}//GEN-BEGIN:|18-getter|2|
        return exitCommand;
    }
//</editor-fold>//GEN-END:|18-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: form ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initialized instance of form component.
     *
     * @return the initialized component instance
     */
    public Form getForm() {
        if (form == null) {
//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
form = new Form("Currency Converter", new Item[]{getStringItem1(), getStringItem2(), getTextField(), getStringItem()});//GEN-BEGIN:|14-getter|1|14-postInit
            form.addCommand(getExitCommand());
            form.addCommand(getChooseCurrencyFrom());
            form.addCommand(getChooseCurrencyTo());
            form.addCommand(getConvertOkCommand());
            form.addCommand(getShowCurrenciesItemCommand());
            form.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
            // write post-init user code here
}//GEN-BEGIN:|14-getter|2|
        return form;
    }
//</editor-fold>//GEN-END:|14-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem ">//GEN-BEGIN:|16-getter|0|16-preInit
    /**
     * Returns an initialized instance of stringItem component.
     *
     * @return the initialized component instance
     */
    public StringItem getStringItem() {
        if (stringItem == null) {
//GEN-END:|16-getter|0|16-preInit
            // write pre-init user code here
stringItem = new StringItem("Converted Value:", "0");//GEN-BEGIN:|16-getter|1|16-postInit
            stringItem.setLayout(ImageItem.LAYOUT_DEFAULT | ImageItem.LAYOUT_NEWLINE_BEFORE | Item.LAYOUT_SHRINK | Item.LAYOUT_EXPAND);//GEN-END:|16-getter|1|16-postInit
            // write post-init user code here
}//GEN-BEGIN:|16-getter|2|
        return stringItem;
    }
//</editor-fold>//GEN-END:|16-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: chooseCurrencyFrom ">//GEN-BEGIN:|26-getter|0|26-preInit
    /**
     * Returns an initialized instance of chooseCurrencyFrom component.
     *
     * @return the initialized component instance
     */
    public Command getChooseCurrencyFrom() {
        if (chooseCurrencyFrom == null) {
//GEN-END:|26-getter|0|26-preInit
 // write pre-init user code here
chooseCurrencyFrom = new Command("Choose Currency From", Command.ITEM, 0);//GEN-LINE:|26-getter|1|26-postInit
 // write post-init user code here
}//GEN-BEGIN:|26-getter|2|
        return chooseCurrencyFrom;
    }
//</editor-fold>//GEN-END:|26-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: chooseCurrencyTo ">//GEN-BEGIN:|28-getter|0|28-preInit
    /**
     * Returns an initialized instance of chooseCurrencyTo component.
     *
     * @return the initialized component instance
     */
    public Command getChooseCurrencyTo() {
        if (chooseCurrencyTo == null) {
//GEN-END:|28-getter|0|28-preInit
 // write pre-init user code here
chooseCurrencyTo = new Command("Choose Currency To", Command.ITEM, 0);//GEN-LINE:|28-getter|1|28-postInit
 // write post-init user code here
}//GEN-BEGIN:|28-getter|2|
        return chooseCurrencyTo;
    }
//</editor-fold>//GEN-END:|28-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: chooseOkCommand ">//GEN-BEGIN:|31-getter|0|31-preInit
    /**
     * Returns an initialized instance of chooseOkCommand component.
     *
     * @return the initialized component instance
     */
    public Command getChooseOkCommand() {
        if (chooseOkCommand == null) {
//GEN-END:|31-getter|0|31-preInit
 // write pre-init user code here
chooseOkCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|31-getter|1|31-postInit
 // write post-init user code here
}//GEN-BEGIN:|31-getter|2|
        return chooseOkCommand;
    }
//</editor-fold>//GEN-END:|31-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|34-getter|0|34-preInit
    /**
     * Returns an initialized instance of backCommand component.
     *
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {
//GEN-END:|34-getter|0|34-preInit
 // write pre-init user code here
backCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|34-getter|1|34-postInit
 // write post-init user code here
}//GEN-BEGIN:|34-getter|2|
        return backCommand;
    }
//</editor-fold>//GEN-END:|34-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: convertOkCommand ">//GEN-BEGIN:|38-getter|0|38-preInit
    /**
     * Returns an initialized instance of convertOkCommand component.
     *
     * @return the initialized component instance
     */
    public Command getConvertOkCommand() {
        if (convertOkCommand == null) {
//GEN-END:|38-getter|0|38-preInit
 // write pre-init user code here
convertOkCommand = new Command("Convert", Command.OK, 0);//GEN-LINE:|38-getter|1|38-postInit
 // write post-init user code here
}//GEN-BEGIN:|38-getter|2|
        return convertOkCommand;
    }
//</editor-fold>//GEN-END:|38-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem1 ">//GEN-BEGIN:|40-getter|0|40-preInit
    /**
     * Returns an initialized instance of stringItem1 component.
     *
     * @return the initialized component instance
     */
    public StringItem getStringItem1() {
        if (stringItem1 == null) {
//GEN-END:|40-getter|0|40-preInit
 // write pre-init user code here
stringItem1 = new StringItem("Choose Currency From:", "US Dollar (USD)", Item.BUTTON);//GEN-BEGIN:|40-getter|1|40-postInit
            stringItem1.setLayout(ImageItem.LAYOUT_DEFAULT | ImageItem.LAYOUT_NEWLINE_BEFORE | Item.LAYOUT_SHRINK | Item.LAYOUT_EXPAND);//GEN-END:|40-getter|1|40-postInit
 // write post-init user code here
}//GEN-BEGIN:|40-getter|2|
        return stringItem1;
    }
//</editor-fold>//GEN-END:|40-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem2 ">//GEN-BEGIN:|41-getter|0|41-preInit
    /**
     * Returns an initialized instance of stringItem2 component.
     *
     * @return the initialized component instance
     */
    public StringItem getStringItem2() {
        if (stringItem2 == null) {
//GEN-END:|41-getter|0|41-preInit
 // write pre-init user code here
stringItem2 = new StringItem("Choose Currency To:", "Ukrainian Hryvnia (UAH)", Item.BUTTON);//GEN-BEGIN:|41-getter|1|41-postInit
            stringItem2.setLayout(ImageItem.LAYOUT_DEFAULT | ImageItem.LAYOUT_NEWLINE_BEFORE | Item.LAYOUT_SHRINK | Item.LAYOUT_EXPAND);//GEN-END:|41-getter|1|41-postInit
 // write post-init user code here
}//GEN-BEGIN:|41-getter|2|
        return stringItem2;
    }
//</editor-fold>//GEN-END:|41-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: list ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initialized instance of list component.
     *
     * @return the initialized component instance
     */
    public List getList() {
        if (list == null) {
//GEN-END:|22-getter|0|22-preInit
                // write pre-init user code here
list = new List("Select Currency", Choice.IMPLICIT);//GEN-BEGIN:|22-getter|1|22-postInit
            list.addCommand(getChooseOkCommand());
            list.addCommand(getBackCommand());
            list.setCommandListener(this);//GEN-END:|22-getter|1|22-postInit
            
// write post-init user code here
}//GEN-BEGIN:|22-getter|2|
        return list;
    }
//</editor-fold>//GEN-END:|22-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: listAction ">//GEN-BEGIN:|22-action|0|22-preAction
    /**
     * Performs an action assigned to the selected list element in the list
     * component.
     */
    public void listAction() {
//GEN-END:|22-action|0|22-preAction
 // enter pre-action user code here
String __selectedString = getList().getString(getList().getSelectedIndex());//GEN-LINE:|22-action|1|22-postAction
 // enter post-action user code here
}//GEN-BEGIN:|22-action|2|
//</editor-fold>//GEN-END:|22-action|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField ">//GEN-BEGIN:|42-getter|0|42-preInit
    /**
     * Returns an initialized instance of textField component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField() {
        if (textField == null) {
//GEN-END:|42-getter|0|42-preInit
 // write pre-init user code here
textField = new TextField("Input Currency Value:", "0", 32, TextField.NUMERIC);//GEN-BEGIN:|42-getter|1|42-postInit
            textField.setLayout(ImageItem.LAYOUT_DEFAULT | ImageItem.LAYOUT_NEWLINE_BEFORE | Item.LAYOUT_SHRINK | Item.LAYOUT_EXPAND);//GEN-END:|42-getter|1|42-postInit
 // write post-init user code here
}//GEN-BEGIN:|42-getter|2|
        return textField;
    }
//</editor-fold>//GEN-END:|42-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: showCurrenciesItemCommand ">//GEN-BEGIN:|43-getter|0|43-preInit
    /**
     * Returns an initialized instance of showCurrenciesItemCommand component.
     *
     * @return the initialized component instance
     */
    public Command getShowCurrenciesItemCommand() {
        if (showCurrenciesItemCommand == null) {
//GEN-END:|43-getter|0|43-preInit
 // write pre-init user code here
showCurrenciesItemCommand = new Command("Main Currencies Graph", "Main Currencies Graph", Command.ITEM, 0);//GEN-LINE:|43-getter|1|43-postInit
 // write post-init user code here
}//GEN-BEGIN:|43-getter|2|
        return showCurrenciesItemCommand;
    }
//</editor-fold>//GEN-END:|43-getter|2|

    private CurrenciesGraph currenciesGraph = null;
    private Command backToFormCommand;
    
    public CurrenciesGraph getCurrenciesGraph() {
        if (currenciesGraph == null) {
            currenciesGraph = new CurrenciesGraph();
            backToFormCommand = new Command("Back", Command.BACK, 0);
            currenciesGraph.addCommand(backToFormCommand);
            currenciesGraph.setCommandListener(this);
        }
        
        return currenciesGraph;
    }

    public float[] rates = null;

    class CurrenciesGraph extends Canvas {
        private int screenWidth;
        private int screenHeight;
        
        protected void paint(final Graphics g) {
            screenWidth = getWidth();
            screenHeight = getHeight();

            // clear screen
            g.setColor(0xFFFFFF);
            g.fillRect(0, 0, screenWidth, screenHeight);
            
            final String[] codes = {"GBP", "EUR", "USD", "CAD", "AUD", "NZD", "PLN", "CNY", "CZK", "RUB", "JPY"};
            // czech republic koruna, polish zloty, new zeland dollar, canadian dollar,
            // australian dollar, japanese yen, chinese yuan, british pound sterling
            final int[] colors = {0xFFFF88, 0xCDEB8B, 0xC3D9FF, 0xc9b77a, 0xf68a5f, 
                0xeed4b3, 0xd3d1cc, 0xe1d0b5, 0xE1C61E, 0xb9c1b6, 0xffad5b};
          
            float k = (float) screenWidth / 30.0f;
            final int rowHeight = screenHeight / 11;
            int i;
            
            if (rates == null) {
                rates = new float[11];
                for (i = 0; i <= 10; i++) {
                    rates[i] = 0;
                }
                
                for (i = 0; i <= 10; i++) {
                    new Thread(new GraphRunnable(codes[i], i)).start();
                }
            } else {
                for (i = 0; i <= 10; i++) {
                    g.setColor(colors[i]);
                    g.fillRect(0, rowHeight * i, (int) (k * rates[i]), rowHeight);
                    g.setColor(0x0);
                    g.drawString(
                            codes[i] + ": " + rates[i], 
                            5, rowHeight * i + rowHeight / 3, Graphics.TOP | Graphics.LEFT);
                }
                
            }
        }
        
    }
    
    class GraphRunnable implements Runnable {
        private String code;
        private final int i;

        public GraphRunnable(String code, int i) {
            this.code = code;
            this.i = i;
        }

        public void run() {
            rates[i] = Float.parseFloat(getConvertedValue(code, "UAH", "1", false));
            currenciesGraph.repaint();
        }
    }        
    
    private String getConvertedValue(String from, String to, String amount, boolean withCode) {
        String url = "https://www.google.com/finance/converter?a=" + amount + "&from=" +
                from + "&to=" + to + ";deviceside=false;interface=wifi";

        System.out.println(url);
        
        String result = "";
        
        try {
            // <span class=bld>25.9152 USD</span>

            HttpConnection connection = (HttpConnection) Connector.open(url);
            connection.setRequestMethod(HttpConnection.GET);

            connection.getResponseCode();

            InputStream in = connection.openInputStream();

            StringBuffer buffer = new StringBuffer();
            int ch;

            while ((ch = in.read()) != -1) {
                if (ch != '\n') {
                    buffer.append((char) ch);
                } else {
                    String line = buffer.toString();
                    if (line.indexOf("bld>") != -1) {
                        if (withCode) {
                            result = line.substring(line.indexOf("bld>") + 4, line.indexOf("</span"));
                        } else {
                            result = line.substring(line.indexOf("bld>") + 4, line.indexOf("</span") - 4);
                        }
                    }

                    buffer = new StringBuffer();
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return result;
    }
    
    private void fillCurrenciesList() {
        new Thread(new Runnable(){
            public void run() {
                try {
                    // https://www.google.com/finance/converter?a=1000&from=USD&to=UAH

                    HttpConnection connection = (HttpConnection) Connector.open("https://www.google.com/finance/converter;deviceside=false;interface=wifi");
                    connection.setRequestMethod(HttpConnection.GET);

                    connection.getResponseCode();

                    InputStream in = connection.openInputStream();

                    StringBuffer buffer = new StringBuffer();
                    int ch, i;

                    lines:
                    while ((ch = in.read()) != -1) {
                        if (ch != '\n') {
                            buffer.append((char) ch);
                        } else {
                            String line = buffer.toString();
                            if (line.indexOf("<option") != -1) {
                                String cr = line.substring(line.indexOf(">") + 1, line.substring(5).indexOf("(") + 5);
                                cr += "(" + line.substring(line.indexOf("value=\"") + 7, line.indexOf('"', line.indexOf("value=\"") + 7)) + ")";
                                for (i = 0; i <= list.size() - 1; i++) {
                                    if (list.getString(i).equals(cr)) {
                                        buffer = new StringBuffer();
                                        continue lines;
                                    }
                                }
                                list.append(cr, null);
                            }
                            buffer = new StringBuffer();
                        }
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }
    
    /**
     * Returns a display instance.
     *
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started. Checks whether the MIDlet have been
     * already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     *
     * @param unconditional if true, then the MIDlet has to be unconditionally
     * terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }
    
}
