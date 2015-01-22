Public Class Form1

    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        With NumericUpDown1
            .TextAlign = HorizontalAlignment.Right 'Cambiar la alineación del texto lo primero; si no, peta :(
            .Hexadecimal = True
            .Minimum = 0
            .Maximum = &HFFFFFF '16777215 ' #FFFFFF
            .Value = 0
            .Increment = 0.25
            .ReadOnly = False
            .DecimalPlaces = 2
            .ThousandsSeparator = True
        End With

        With DomainUpDown1
            .TextAlign = HorizontalAlignment.Left
            .ReadOnly = False
            .Sorted = False
        End With
    End Sub

    Private Sub NumericUpDown1_ValueChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles NumericUpDown1.ValueChanged
        PictureBox1.BackColor = Color.FromArgb(NumericUpDown1.Value + &HAE000000)
        Label1.Text = NumericUpDown1.Value
    End Sub

    Private Sub DomainUpDown1_SelectedItemChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles DomainUpDown1.SelectedItemChanged
        PictureBox2.BackColor = Color.FromName(DomainUpDown1.Text)
    End Sub
End Class
