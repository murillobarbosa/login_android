package br.senai.sp.jandira.login.model

import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.painter.Painter
import br.senai.sp.jandira.login.R
import java.time.LocalDate
import java.util.Date

data class Trip(
    var id: Long = 0,
    var location: String = "",
    var description: String = "",
    var startDate: LocalDate = LocalDate.of(2000,1, 1),
    var endDate: LocalDate = LocalDate.of(2000,1, 1),
    var image: Int = R.drawable.baseline_no_photography_24
)
