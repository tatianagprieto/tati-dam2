Public Class x

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        If MessageBox.Show("¿Desea usted cerrar el programa?", "Dialogo de Cierre", MessageBoxButtons.YesNo, MessageBoxIcon.Question, MessageBoxDefaultButton.Button2) = Windows.Forms.DialogResult.Yes Then

            MsgBox("Muchas gracias por su asistencia, nos vemos pronto.", MessageBoxDefaultButton.Button1, "c u soon.")

            Me.Close()
        End If

    End Sub
End Class
