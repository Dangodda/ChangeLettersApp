package dan.godda.changelettersapp;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    String originalText;
    char letterChoice;
    char newLetter;
    String changedText;
    String newLine;


    EditText moriginalText;
    EditText firstLetter;
    EditText mchangeLetter;
    TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moriginalText = findViewById(R.id.uioriginalText);
        firstLetter = findViewById(R.id.uilChoice);
        mchangeLetter = findViewById(R.id.uilNew);
        mResult = findViewById(R.id.uiResult);
    }

    public void chamgeLineOnClick(View view)
    {
        originalText = moriginalText.getText().toString();

        if (originalText.equals(""))
        {
            Toast.makeText(this, "Please emter text to edit", Toast.LENGTH_SHORT).show();
        }
        else {
            if (firstLetter.getText().toString().equals("")) {
                Toast.makeText(this, "Please emter letter to chamge", Toast.LENGTH_SHORT).show();
            } else {
                letterChoice = firstLetter.getText().toString().charAt(0);

                if (mchangeLetter.getText().toString().equals("")) {
                    Toast.makeText(this, "Please emter letter to chamge to", Toast.LENGTH_SHORT).show();
                } else {
                    newLetter = mchangeLetter.getText().toString().charAt(0);

                    changedText = chamgeLetter(originalText);
                    mResult.setText(changedText);
                }
            }
        }
    }

    public String chamgeLetter(String string)
    {
        char chars[] = new char[string.length()];
        int index = 0;

        for (int z = 0; z < string.length(); z++) {

            if (string.charAt(z) == letterChoice)
            {
                index = z;
                chars[z] = newLetter;
            }
            else
            {
                chars[index] = string.charAt(z);
            }
            index++;
        }
        newLine = String.valueOf(chars);
        return newLine;
    }


    public void removeVowelOnClick(View view)
    {
        originalText = moriginalText.getText().toString();

        if (originalText.equals(""))
            {
                Toast.makeText(this, "Please emter text to edit", Toast.LENGTH_SHORT).show();
            }
        else
            {

            changedText = changeVowel(originalText);
            mResult.setText(changedText);
            }
    }

    public String changeVowel(String string)
    {
        char chars[] = new char[string.length()];
        int index = 0;
        Character blank = null;

        for (int z = 0; z < string.length(); z++) {

            if (string.charAt(z) == 'a' || string.charAt(z) == 'e' || string.charAt(z) == 'i' || string.charAt(z) == 'o' || string.charAt(z) == 'u')
            {
                index = z;
                chars[z] = Character.UNASSIGNED;
            }
            else
            {
                chars[index] = string.charAt(z);
            }
            index++;
        }
        newLine = String.valueOf(chars);

        return newLine;
    }


    public void removeConsonantOnClick(View view)
    {
        originalText = moriginalText.getText().toString();

        if (originalText.equals(""))
        {
            Toast.makeText(this, "Please emter text to edit", Toast.LENGTH_SHORT).show();
        }
        else
        {
            changedText = changeConsonant(originalText);
            mResult.setText(changedText);
        }
    }

    public String changeConsonant(String string)
    {
        char chars[] = new char[string.length()];
        int index = 0;
        Character blank = null;

        for (int z = 0; z < string.length(); z++) {

            if (string.charAt(z) == 'b' || string.charAt(z) == 'c' || string.charAt(z) == 'd' || string.charAt(z) == 'f' || string.charAt(z) == 'g' || string.charAt(z) == 'h'
            || string.charAt(z) == 'j' || string.charAt(z) == 'k' || string.charAt(z) == 'l' || string.charAt(z) == 'm' || string.charAt(z) == 'n' || string.charAt(z) == 'p'
            || string.charAt(z) == 'q' || string.charAt(z) == 'r' || string.charAt(z) == 's' || string.charAt(z) == 't' || string.charAt(z) == 'v' || string.charAt(z) == 'w'
            || string.charAt(z) == 'x' || string.charAt(z) == 'y' || string.charAt(z) == 'z')
            {
                index = z;
                chars[z] = Character.UNASSIGNED;
            }
            else
            {
                chars[index] = string.charAt(z);
            }
            index++;
        }
            return newLine;

    }


    public void copytoClipbaord(View view)
    {
        final android.content.ClipboardManager clipboardManager = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("Source Text", newLine);
        clipboardManager.setPrimaryClip(clipData);

        String tText;
        tText = "'"  + newLine + "' copied to clipboard";
        Toast.makeText(this, tText, Toast.LENGTH_SHORT).show();
    }

    public void lemgthClick(View view)
    {
        launchBrowser("http://lemgthbook.com/");
    }

    public void launchBrowser (String url)
    {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }


}
