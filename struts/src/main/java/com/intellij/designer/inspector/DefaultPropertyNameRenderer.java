/*
 * Copyright (c) 2000-2006 JetBrains s.r.o. All Rights Reserved.
 */

package com.intellij.designer.inspector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * @author spleaner
 */
public class DefaultPropertyNameRenderer<P extends Property> implements PropertyRenderer<P> {
  private final JLabel myLabel;

  public DefaultPropertyNameRenderer() {
    myLabel = new JLabel();
    myLabel.setOpaque(true);
    myLabel.setBorder(new EmptyBorder(0, 5, 0, 0));
  }

  @Override
  public JComponent getRendererComponent(final P property, final RenderingContext context) {
    myLabel.setText(property.getName().toString());
    myLabel.setBackground(context.getPresentationManager().getBackgroundColor(property, context.isSelected()));
    myLabel.setForeground(context.isSelected() ? context.getInspector().getSelectionForeground() : context.getInspector().getForeground());
    return myLabel;
  }

  @Override
  public boolean accepts(final P property) {
    return true;
  }
}
