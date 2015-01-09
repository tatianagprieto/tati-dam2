Public Class Form1

    Private Sub Label1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Label1.Click

    End Sub

    Private Sub OpenFileDialog1_FileOk(ByVal sender As System.Object, ByVal e As System.ComponentModel.CancelEventArgs) Handles OpenFileDialog1.FileOk

    End Sub

    Private Sub AbrirToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles AbrirToolStripMenuItem.Click
        OpenFileDialog1.Filter = "Archivos de texto enriquecido|*.rtf|Todos|*.*"
        'OpenFileDialog1.ShowDialog()

        If OpenFileDialog1.ShowDialog = Windows.Forms.DialogResult.OK Then

            RichTextBox1.LoadFile(OpenFileDialog1.FileName)
            TextBox1.Text = OpenFileDialog1.FileName
        End If
    End Sub



    Private Sub GuardarToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles GuardarToolStripMenuItem.Click
        SaveFileDialog1.Filter = "Texto rico|*.rtf"

        If SaveFileDialog1.ShowDialog() = Windows.Forms.DialogResult.OK Then
            RichTextBox1.SaveFile(TextBox1.Text)
        End If
    End Sub


    Private Sub GuardarComoToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles GuardarComoToolStripMenuItem.Click

    End Sub

    Private Sub ImprimirToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ImprimirToolStripMenuItem.Click

    End Sub

    Private Sub SalirToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles SalirToolStripMenuItem.Click

    End Sub

    Private Sub EventoToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles EventoToolStripMenuItem.Click

    End Sub

    Private Sub ColasToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ColasToolStripMenuItem.Click

    End Sub

    Private Sub NuevoToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles NuevoToolStripMenuItem.Click
        TextBox1.Clear()
        RichTextBox1.Clear()
    End Sub
End Class
