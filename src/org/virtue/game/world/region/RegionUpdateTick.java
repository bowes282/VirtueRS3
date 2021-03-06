/**
 * Copyright (c) 2014 Virtue Studios
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions\:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.virtue.game.world.region;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Im Frizzy <skype:kfriz1998>
 * @author Frosty Teh Snowman <skype:travis.mccorkle>
 * @author Arthur <skype:arthur.behesnilian>
 * @author Sundays211
 * @since 5/11/2014
 */
public class RegionUpdateTick extends Thread {
	
	private RegionManager regions;

	/**
	 * The {@link Logger} Instance
	 */
	private static Logger logger = LoggerFactory.getLogger(RegionUpdateTick.class);
	
	public RegionUpdateTick (RegionManager regions) {
		this.regions = regions;
	}

	@Override
	public void run () {
		while (true) {
			try {
				long currentTime = System.currentTimeMillis();
				regions.updateRegions();
				long last_cycle = System.currentTimeMillis();
				long sleepTime = 600 + currentTime - last_cycle;
				if (sleepTime <= 0) {
					continue;
				}
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException ex) {
					logger.error("Exception on region update tick: ", ex);
				}
			} catch (Exception ex) {
				logger.error("Exception on region update tick: ", ex);
			}
		}
	}
}
