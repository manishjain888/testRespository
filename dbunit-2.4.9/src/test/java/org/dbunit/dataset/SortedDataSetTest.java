/*
 *
 * The DbUnit Database Testing Framework
 * Copyright (C)2002-2004, DbUnit.org
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */

package org.dbunit.dataset;

import java.io.FileReader;

import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.testutil.TestUtils;

/**
 * @author Manuel Laflamme
 * @version $Revision: 1162 $
 * @since Feb 19, 2003
 */
public class SortedDataSetTest extends AbstractDataSetDecoratorTest
{
    public SortedDataSetTest(String s)
    {
        super(s);
    }

    protected IDataSet createDataSet() throws Exception
    {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(
                TestUtils.getFileReader("xml/sortedDataSetTest.xml"));

        return new SortedDataSet(dataSet);
    }

}




