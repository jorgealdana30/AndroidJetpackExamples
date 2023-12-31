package com.jorgealdana.modifiersexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jorgealdana.modifiersexample.ui.theme.ModifiersExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModifiersExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        ModifierBackgroundColor()
                        TextWidthPadding()
                        WidthAndHeightModifier()
                        //SizeModifier()
                        //FillWidthModifier()
                        //FillHeightModifier()
                        AlphaAndRotateModifier()
                        ScaleModifier()
                    }
                }
            }
        }
    }
}

@Composable
fun ModifierBackgroundColor() {
    Text(text = "Text with green background color", Modifier.background(color = Color.Green))
}

@Composable
fun Space() {
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun TextWidthPadding() {
    Text(
        text = "Text with Padding and Margin",
        color = Color.White,
        modifier =
        Modifier
            .padding(10.dp) //Outer padding (margin)
            .background(color = Color.Green)
            .padding(5.dp) //inner padding (padding)
    )
}

@Composable
fun WidthAndHeightModifier() {
    Text(
        text = "Width and Height",
        color = Color.White,
        modifier =
        Modifier
            .padding(20.dp)
            .background(color = Color.Blue)
            .width(300.dp)
            .height(400.dp)
            .padding(20.dp)
    )
}

@Composable
fun SizeModifier() {
    Text(
        text = "Text with Size",
        modifier = Modifier
            .size(100.dp)
            .background(color = Color.Red)
    )
    Text(
        text = "Text with another size",
        modifier = Modifier
            .size(width = 200.dp, height = 50.dp)
            .background(color = Color.Yellow)
    )
}

@Composable
fun FillWidthModifier() {
    Text(
        text = "Fill Width Modifier",
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth(1f)
            .background(color = Color.Magenta)
            .padding(10.dp)
    )
}

@Composable
fun FillHeightModifier() {
    Text(
        text = " Text with 75% Height ",
        color = Color.White,
        modifier = Modifier
            .background(Color.Green)
            .fillMaxHeight(0.75f) //75% area fill
    )
}

@Composable
fun AlphaAndRotateModifier() {
    Row {
        Box(
            modifier = Modifier
                .rotate(250f)
                .size(150.dp)
                .alpha(0.3f)
                .background(color = Color.Cyan)
        )
        Box(
            modifier = Modifier
                .rotate(-150f)
                .size(150.dp)
                .alpha(0.3f)
                .background(color = Color.Red)
        )
    }
}

@Composable
fun ScaleModifier() {
    Box(
        modifier = Modifier
            .scale(scaleX = 5f, scaleY = 10f)
            .background(color = Color.LightGray)
            .size(20.dp)
    )
}

@Composable
fun WeightModifier() {
    Row {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(color = Color.Red)
        ) {
            Text(text = "Weight = 1", color = Color.White)
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .background(color = Color.Blue)
        ) {
            Text(text = "Weight = 1", color = Color.White)
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .background(color = Color.Magenta)
        ) {
            Text(text = "Weight = 1", color = Color.White)
        }
        Column(
            modifier = Modifier
                .weight(2f)
                .background(color = Color.Green)
        ) {
            Text(text = "Weight = 2", color = Color.White)
        }
    }

    /*Weight is the sum of all the child in the parent, follow this formula: childWeight1 + childWeight 2 + ... = totalWeight, then,
    to get width space for each child use childWeight1 / totalWeight = childWidth1
    */
}

@Composable
fun BorderModifier() {
    Text(
        text = "Text with Red Border",
        modifier = Modifier
            .padding(10.dp)
            .border(2.dp, color = Color.Red, shape = CutCornerShape(10.dp))
            .padding(10.dp)
    )

    Text(
        text = "Text with round border",
        modifier = Modifier
            .padding(10.dp)
            .border(
                2.dp, SolidColor(Color.Green),
                RoundedCornerShape(20.dp)
            )
            .padding(10.dp)
    )

    //CircleShape, RectangleShape, CutCornerShape, RoundedCornerShape
}

@Composable
fun ClipModifier() {
    Text(
        text = "Text with Clipped background",
        color = Color.White,
        modifier = Modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(Color.Blue)
            .padding(15.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ModifiersExampleTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                /*ModifierBackgroundColor()
                TextWidthPadding()
                WidthAndHeightModifier()
                //SizeModifier()
                //FillWidthModifier()
                //FillHeightModifier()
                AlphaAndRotateModifier()
                ScaleModifier()*/
                WeightModifier()
                BorderModifier()
                ClipModifier()
            }
        }
    }
}