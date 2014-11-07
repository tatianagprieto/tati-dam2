Public Class Form1

    Private Sub Label1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Label1.Click

    End Sub

    Private Sub ComboBox2_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ComboBox2.SelectedIndexChanged

    End Sub

    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        ComboBox1.Items.Add("Madrid")
        ComboBox1.Items.Add("Almería")
        ComboBox1.Items.Add("Lugo")
        ComboBox2.Items.Add("Madrid")
        ComboBox2.Items.Add("Almería")
        ComboBox2.Items.Add("Lugo")
        ComboBox3.Items.Add("Madrid")
        ComboBox3.Items.Add("Almería")
        ComboBox3.Items.Add("Lugo")

        'ComboBox1.Text = "Almeria"

        ComboBox1.SelectedIndex = 1

        Label4.Text = DateString
        'Label5.Text = TimeString

    End Sub

    'Private Sub ComboBox1_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ComboBox1.SelectedIndexChanged
    '    'If ComboBox1.Then Then

    '    'End If
    '    TextBox1.Text = ComboBox1.Text


    'End Sub

    'Private Sub ComboBox1_SelectedValueChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles ComboBox1.SelectedValueChanged
    '    TextBox1.Text = ComboBox1.Text

    'End Sub

    Private Sub ComboBox1_TextChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles ComboBox1.TextChanged
        TextBox1.Text = ComboBox1.Text
    End Sub


    Private Sub Timer1_Tick(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Timer1.Tick
        Label5.Text = TimeString
        Label4.Text = Format(Now, "dd - mm -yyyy")
    End Sub

    Private Sub LinkLabel3_LinkClicked(ByVal sender As System.Object, ByVal e As System.Windows.Forms.LinkLabelLinkClickedEventArgs) Handles LinkLabel3.LinkClicked
        System.Diagnostics.Process.Start("http:\\www.renfe.es")
    End Sub

    Private Sub LinkLabel1_LinkClicked(ByVal sender As System.Object, ByVal e As System.Windows.Forms.LinkLabelLinkClickedEventArgs) Handles LinkLabel1.LinkClicked
        'System.Diagnostics.Process.Start()
    End Sub

    Private Sub ComboBox4_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ComboBox4.SelectedIndexChanged
        System.Diagnostics.Process.Start(ComboBox4.Text)


    End Sub

    Private Sub AbrirToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles AbrirToolStripMenuItem.Click
        MsgBox("He pinchado en abrir")

    End Sub
End Class
