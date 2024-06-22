package com.vishal2376.scrollblock.presentation.common

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.vishal2376.scrollblock.ui.theme.pieChartColors

@Composable
fun CustomPieChart(
    data: List<Int>,
    arcWidth: Dp = 30.dp,
    startAngle: Float = -180f,
    pieChartSize: Dp = 200.dp,
    animDuration: Int = 1000,
    gapDegrees: Float = 26f
) {
    // calculate each arc value
    val totalSum = data.sum()
    val totalGaps = gapDegrees * data.size
    val availableAngle = 360f - totalGaps
    val arcValues = mutableListOf<Float>()

    data.forEachIndexed { index, value ->
        val arc = value.toFloat() / totalSum.toFloat() * availableAngle
        arcValues.add(index, arc)
    }

    var newStartAngle = startAngle

    // animations
    val animationProgress = remember { Animatable(0f) }
    LaunchedEffect(Unit) {
        animationProgress.animateTo(1f, animationSpec = tween(animDuration))
    }

    // draw pie chart
    val totalColors = pieChartColors.size

    Column(
        modifier = Modifier.size(pieChartSize * 1.4f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Canvas(
            modifier = Modifier
                .size(pieChartSize)
                .rotate(90f * animationProgress.value)
        ) {
            arcValues.forEachIndexed { index, arcValue ->
                drawArc(
                    color = pieChartColors[index % totalColors],
                    startAngle = newStartAngle,
                    useCenter = false,
                    sweepAngle = arcValue * animationProgress.value,
                    style = Stroke(width = arcWidth.toPx(), cap = StrokeCap.Round)
                )
                newStartAngle += arcValue + gapDegrees
            }
        }
    }
}


@Preview
@Composable
fun CustomPieChartPreview() {
    val time = listOf<Int>(31,24, 8)
    CustomPieChart(time)
}