package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    public static final String BOOK_ID_KEY = "bookId";

    private ImageView bookImage;
    private Button btnAddToCurrentlyReading, btnAddToWantToRead, btnAddToAlreadyRead, btnAddToFavourites;
    private TextView txtBookName, txtAuthor, txtPages, txtDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();

//        String longDescription = "This extension puts an item in the context menu \n" +
//                "so you can right-click on any element on the page and open its long description.\n" +
//                " It also gives you the option of adding a colored border to\n" +
//                " images with a long description so you know when one is available." +
//                "In this case, the image is also a link, so it has a function. Whenever an image is within a link, the function of the image must be presented in alternative text that is also within the link. In this case, there is no adjacent text within the link that describes the function, so it must be presented within the alt attribute. As a result, option D (\"George Washington\") is likely the best choice. While the words \"George Washington\" in the alt attribute are redundant with the text that follows, in this case the redundancy is necessary to adequately describe the function.\n" +
//                "\n" +
//                "Option A is not adequate. An image that is the only thing inside a link must never have a missing or empty alt attribute. This is because the screen reader must read SOMETHING to identify the link. Screen readers might read the image file name or the URL of the page being linked to, which may or may not be useful. And remember, that the link may be read out of context of the surrounding text, such as when the user is navigating by links within the page. Option B provides content that is not available through the image alone (i.e., you can't tell the image links to Wikipedia simply by looking at it). Option C does not provide an adequate description of the function, especially out of context.\n" +
//                "\n" +
//                "This entire example could also be make much better by placing both the image and the text caption within one link:";
//
//
//        Book book = new Book(1,"1q84 ", "Murakami  ", 200,  "https://images-na.ssl-images-amazon.com/images/I/519EBmsHg2L._SX321_BO1,204,203,200_.jpg",
//                "A work of Maddening Brilliance",longDescription );

        Intent intent = getIntent();
        if (null != intent) {
            int bookId = intent.getIntExtra(BOOK_ID_KEY, -1);
            if (bookId != -1) {
                Book incomingBook = Utils.getInstance(this).getBookBytId(bookId);
                if (null != incomingBook) {
                    setData(incomingBook);


                    handleCurrentlyReadingBooks(incomingBook);
                    handleWantToReadBooks(incomingBook);
                    handlealreadyread(incomingBook);
                    handleFavouriteBooks(incomingBook);

                }
            }
        }
    }

    /**
     * Enable and disable button
     * Add book to already read book Arraylist
     *
     * @param book
     */
    private void handlealreadyread(final Book book) {
        ArrayList<Book> alreadyReadBooks = Utils.getInstance(this).getAlreadyReadBooks();

        boolean existInAlreadyReadBooks = false;
        for (Book b : alreadyReadBooks) {
            if (b.getId() == book.getId()) {
                existInAlreadyReadBooks = true;
            }
        }
        if (existInAlreadyReadBooks) {
            btnAddToAlreadyRead.setEnabled(false);
        } else {
            btnAddToAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance(BookActivity.this).addToAlreadyRead(book)) {
                        Toast.makeText(BookActivity.this, "Book Added ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, AlreadyReadBookActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something Wrong Happened, Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleWantToReadBooks(final Book book) {
        ArrayList<Book> wantToReadBooks = Utils.getInstance(this).getWantToReadBooks();

        boolean existInWantToReadBooks = false;
        for (Book b : wantToReadBooks) {
            if (b.getId() == book.getId()) {
                existInWantToReadBooks = true;
            }
        }
        if (existInWantToReadBooks) {
            btnAddToWantToRead.setEnabled(false);
        } else {
            btnAddToWantToRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance(BookActivity.this).addToWantToRead(book)) {
                        Toast.makeText(BookActivity.this, "Book Added ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, WantToReadActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something Wrong Happened, Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleCurrentlyReadingBooks(final Book book) {
        ArrayList<Book> currentlyReadingBooks = Utils.getInstance(this).getCurrentlyReadingBooks();

        boolean existInCurrentlyReadingBooks = false;
        for (Book b : currentlyReadingBooks) {
            if (b.getId() == book.getId()) {
                existInCurrentlyReadingBooks = true;
            }
        }
        if (existInCurrentlyReadingBooks) {
            btnAddToCurrentlyReading.setEnabled(false);
        } else {
            btnAddToCurrentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance(BookActivity.this).addToCurrentlyReadingBooks(book)) {
                        Toast.makeText(BookActivity.this, "Book Added ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, CurrentlyReadingBooksActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something Wrong Happened, Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void handleFavouriteBooks(final Book book) {
        ArrayList<Book> favouriteBooks = Utils.getInstance(this).getFavouriteBooks();

        boolean existInFavouriteBooks = false;
        for (Book b : favouriteBooks) {
            if (b.getId() == book.getId()) {
                existInFavouriteBooks = true;
            }
        }
        if (existInFavouriteBooks) {
            btnAddToFavourites.setEnabled(false);
        } else {
            btnAddToFavourites.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance(BookActivity.this).addToFavouriteBooks(book)) {
                        Toast.makeText(BookActivity.this, "Book Added ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, FavouriteBooksActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something Wrong Happened, Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void setData(Book book) {
        txtBookName.setText(book.getName());
        txtPages.setText(String.valueOf(book.getPages()));
        txtDescription.setText(book.getLongDesc());
        Glide.with(this)
                .asBitmap().load(book.getImgUrl())
                .into(bookImage);

    }

    private void initViews() {

        txtBookName = findViewById(R.id.txtBookname);
        txtAuthor = findViewById(R.id.txtAuthorNameBookActivity);
        txtDescription = findViewById(R.id.txtDescription);
        txtPages = findViewById(R.id.txtPagesNumber);

        btnAddToAlreadyRead = findViewById(R.id.btnAddToAlreadyRead);
        btnAddToCurrentlyReading = findViewById(R.id.btnAddToCurrentlyReading);
        btnAddToFavourites = findViewById(R.id.btnAddToFavourites);
        btnAddToWantToRead = findViewById(R.id.btnAddToWantToReadList);

        bookImage = findViewById(R.id.imageView);


    }
}