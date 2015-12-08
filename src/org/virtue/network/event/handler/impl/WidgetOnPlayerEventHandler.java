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
package org.virtue.network.event.handler.impl;

import org.virtue.game.World;
import org.virtue.game.entity.player.Player;
import org.virtue.game.entity.region.movement.WidgetOnEntityTarget;
import org.virtue.network.event.context.impl.in.WidgetOnPlayerEventContext;
import org.virtue.network.event.handler.GameEventHandler;

/**
 * @author Im Frizzy <skype:kfriz1998>
 * @author Frosty Teh Snowman <skype:travis.mccorkle>
 * @author Arthur <skype:arthur.behesnilian>
 * @author Kayla <skype:ashbysmith1996>
 * @author Sundays211
 * @since 18/01/2015
 */
public class WidgetOnPlayerEventHandler implements GameEventHandler<WidgetOnPlayerEventContext> {

	/* (non-Javadoc)
	 * @see org.virtue.network.event.handler.GameEventHandler#handle(org.virtue.game.entity.player.Player, org.virtue.network.event.context.GameEventContext)
	 */
	@Override
	public void handle(Player player, WidgetOnPlayerEventContext context) {
		Player target = World.getInstance().getPlayers().get(context.getPlayerIndex());
		if (target != null) {
			player.getMovement().setTarget(new WidgetOnEntityTarget(player, target, 
					context.getIfInterface(),  context.getIfComponent(),
					context.getIfSlot(), context.getIfItem()));
			/*switch (context.getIfInterface()) {
			case 234:
			case 1110://Clan recruit
				handleClanRecruit(player, target, context);
				break;
			default:
				String message = "Interface: id="+context.getIfInterface()+", comp="+context.getIfComponent()
					+", slot="+context.getIfSlot()+", item="+context.getIfItem()
					+" Player: name="+target.getName()+", index="+target.getIndex()
					+", forceRun="+context.forceRun();
			player.getDispatcher().sendGameMessage("Unhanded interface-on-player: "+message);
			System.out.println(message);
			}	*/		
		}
	}
}
