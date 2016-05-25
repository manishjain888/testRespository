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

package org.dbunit.dataset.common.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author fede
 * @author Last changed by: $Author: gommma $
 * @version $Revision: 855 $ $Date: 2008-11-01 14:23:09 +0000 (Sat, 01 Nov 2008) $
 * @since 2.2 (Sep 12, 2004)
 */
public class SeparatorHandler extends AbstractPipelineComponent {

    public static final char DEFAULT_SEPARATOR_CHAR = ',';

    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(SeparatorHandler.class);

    private SeparatorHandler() 
    {
    }
    
    public static final PipelineComponent ACCEPT () {
        logger.debug("ACCEPT() - start");

        return createPipelineComponent(new SeparatorHandler(), new ACCEPT());
    }

    public static final PipelineComponent IGNORE () {
        logger.debug("IGNORE() - start");

        return createPipelineComponent(new SeparatorHandler(), new IGNORE());
    }

    public static final PipelineComponent ENDPIECE () {
        logger.debug("ENDPIECE() - start");

        return createPipelineComponent(new SeparatorHandler(), new ENDPIECE());
    }

    public boolean canHandle(char c) throws IllegalInputCharacterException {
        if(logger.isDebugEnabled())
            logger.debug("canHandle(c={}) - start", String.valueOf(c));

        PipelineConfig pipelineConfig = this.getPipelineConfig();
        if (c == pipelineConfig.getSeparatorChar()) {
            return true;
        }
        return false; //throw new IllegalInputCharacterException("Cannot handle character '" + c + "'");
    }

    static protected class ENDPIECE extends Helper {

        /**
         * Logger for this class
         */
        private static final Logger logger = LoggerFactory.getLogger(ENDPIECE.class);

        void helpWith(char c) throws PipelineException {
            if(logger.isDebugEnabled())
                logger.debug("helpWith(c={}) - start", String.valueOf(c));

            // we are done with the piece
            getHandler().getPipeline().thePieceIsDone();
        }
    }

}
