/*
 *
 *  The DbUnit Database Testing Framework
 *  Copyright (C)2002-2008, DbUnit.org
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 2.1 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this library; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */
package org.dbunit.assertion;

import org.dbunit.dataset.ITable;

/**
 * Value object to hold the difference of a single data cell 
 * found while comparing data.
 * <p>
 * Inspired by the XMLUnit framework.
 * </p>
 * 
 * @author gommma (gommma AT users.sourceforge.net)
 * @author Last changed by: $Author: gommma $
 * @version $Revision: 872 $ $Date: 2008-11-08 15:45:52 +0000 (Sat, 08 Nov 2008) $
 * @since 2.4.0
 */
public class Difference 
{
    private ITable expectedTable;
    private ITable actualTable;
    private int rowIndex;
    private String columnName;
    private Object expectedValue;
    private Object actualValue;
    
    public Difference(ITable expectedTable, ITable actualTable, 
            int rowIndex, String columnName,
            Object expectedValue, Object actualValue) 
    {
        super();
        this.expectedTable = expectedTable;
        this.actualTable = actualTable;
        this.rowIndex = rowIndex;
        this.columnName = columnName;
        this.expectedValue = expectedValue;
        this.actualValue = actualValue;
    }
    
    public ITable getExpectedTable() {
        return expectedTable;
    }


    public ITable getActualTable() {
        return actualTable;
    }


    public int getRowIndex() {
        return rowIndex;
    }

    public String getColumnName() {
        return columnName;
    }

    public Object getExpectedValue() {
        return expectedValue;
    }

    public Object getActualValue() {
        return actualValue;
    }

    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append(getClass().getName()).append("[");
        sb.append("expectedTable=").append(expectedTable);
        sb.append(", actualTable=").append(actualTable);
        sb.append(", rowIndex=").append(rowIndex);
        sb.append(", columnName=").append(columnName);
        sb.append(", expectedValue=").append(expectedValue);
        sb.append(", actualValue=").append(actualValue);
        sb.append("]");
        return sb.toString();
    }
}
