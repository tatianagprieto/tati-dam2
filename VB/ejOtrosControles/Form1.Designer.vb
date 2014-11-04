<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form1
    Inherits System.Windows.Forms.Form

    'Form reemplaza a Dispose para limpiar la lista de componentes.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Requerido por el Diseñador de Windows Forms
    Private components As System.ComponentModel.IContainer

    'NOTA: el Diseñador de Windows Forms necesita el siguiente procedimiento
    'Se puede modificar usando el Diseñador de Windows Forms.  
    'No lo modifique con el editor de código.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.gbEstado = New System.Windows.Forms.GroupBox
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.bolviudo = New System.Windows.Forms.RadioButton
        Me.bolcasado = New System.Windows.Forms.RadioButton
        Me.bolsoltero = New System.Windows.Forms.RadioButton
        Me.Label1 = New System.Windows.Forms.Label
        Me.CheckBox1 = New System.Windows.Forms.CheckBox
        Me.gbEstado.SuspendLayout()
        Me.SuspendLayout()
        '
        'gbEstado
        '
        Me.gbEstado.AutoSize = True
        Me.gbEstado.Controls.Add(Me.TextBox1)
        Me.gbEstado.Controls.Add(Me.bolviudo)
        Me.gbEstado.Controls.Add(Me.bolcasado)
        Me.gbEstado.Controls.Add(Me.bolsoltero)
        Me.gbEstado.Location = New System.Drawing.Point(12, 12)
        Me.gbEstado.Name = "gbEstado"
        Me.gbEstado.Size = New System.Drawing.Size(469, 142)
        Me.gbEstado.TabIndex = 0
        Me.gbEstado.TabStop = False
        Me.gbEstado.Text = "Estado civil"
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(307, 66)
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.ReadOnly = True
        Me.TextBox1.Size = New System.Drawing.Size(100, 20)
        Me.TextBox1.TabIndex = 6
        '
        'bolviudo
        '
        Me.bolviudo.AutoSize = True
        Me.bolviudo.Location = New System.Drawing.Point(201, 90)
        Me.bolviudo.Name = "bolviudo"
        Me.bolviudo.Size = New System.Drawing.Size(52, 17)
        Me.bolviudo.TabIndex = 5
        Me.bolviudo.TabStop = True
        Me.bolviudo.Text = "Viudo"
        Me.bolviudo.UseVisualStyleBackColor = True
        '
        'bolcasado
        '
        Me.bolcasado.AutoSize = True
        Me.bolcasado.Location = New System.Drawing.Point(201, 67)
        Me.bolcasado.Name = "bolcasado"
        Me.bolcasado.Size = New System.Drawing.Size(61, 17)
        Me.bolcasado.TabIndex = 4
        Me.bolcasado.TabStop = True
        Me.bolcasado.Text = "Casado"
        Me.bolcasado.UseVisualStyleBackColor = True
        '
        'bolsoltero
        '
        Me.bolsoltero.AutoSize = True
        Me.bolsoltero.Location = New System.Drawing.Point(201, 44)
        Me.bolsoltero.Name = "bolsoltero"
        Me.bolsoltero.Size = New System.Drawing.Size(58, 17)
        Me.bolsoltero.TabIndex = 3
        Me.bolsoltero.TabStop = True
        Me.bolsoltero.Text = "Soltero"
        Me.bolsoltero.UseVisualStyleBackColor = True
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(119, 232)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(96, 13)
        Me.Label1.TabIndex = 1
        Me.Label1.Text = "<-- Cambia mi color"
        '
        'CheckBox1
        '
        Me.CheckBox1.AutoSize = True
        Me.CheckBox1.Location = New System.Drawing.Point(65, 231)
        Me.CheckBox1.Name = "CheckBox1"
        Me.CheckBox1.Size = New System.Drawing.Size(48, 17)
        Me.CheckBox1.TabIndex = 2
        Me.CheckBox1.Text = "Rojo"
        Me.CheckBox1.UseVisualStyleBackColor = True
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(96.0!, 96.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Dpi
        Me.AutoSize = True
        Me.ClientSize = New System.Drawing.Size(566, 331)
        Me.Controls.Add(Me.gbEstado)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.CheckBox1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.gbEstado.ResumeLayout(False)
        Me.gbEstado.PerformLayout()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents gbEstado As System.Windows.Forms.GroupBox
    Friend WithEvents CheckBox1 As System.Windows.Forms.CheckBox
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents bolviudo As System.Windows.Forms.RadioButton
    Friend WithEvents bolcasado As System.Windows.Forms.RadioButton
    Friend WithEvents bolsoltero As System.Windows.Forms.RadioButton
    Friend WithEvents TextBox1 As System.Windows.Forms.TextBox

End Class
