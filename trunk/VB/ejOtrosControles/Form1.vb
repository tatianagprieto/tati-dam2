Public Class Form1

    Private Sub CheckBox1_CheckedChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles CheckBox1.CheckedChanged
        If sender.checked Then
            Label1.ForeColor = Color.Red
        Else
            Label1.ForeColor = Color.Black

        End If
    End Sub


    Private Sub estadoCivil(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles bolsoltero.CheckedChanged, bolcasado.CheckedChanged, bolviudo.CheckedChanged

        TextBox1.Text = sender.Text

    End Sub
End Class
