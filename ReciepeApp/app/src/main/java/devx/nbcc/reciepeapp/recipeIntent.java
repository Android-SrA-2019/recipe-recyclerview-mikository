package devx.nbcc.reciepeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class recipeIntent extends AppCompatActivity {

    TextView name;
    TextView directions;
    TextView ingridients;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_intent);

        name = (TextView)findViewById(R.id.name);
        directions = (TextView)findViewById(R.id.directions);
        ingridients = (TextView)findViewById(R.id.ingridients);
        image = (ImageView)findViewById(R.id.img);
        Reciepe r;
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            r = (Reciepe) extras.getSerializable("RECIEPE");
            name.setText(r.getName());
            directions.setText(r.getDescription());
            ingridients.setText(r.getIngredients());
            Picasso.get()
                    .load(r.getImage())
                    .fit()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(image);
        }
    }
}
